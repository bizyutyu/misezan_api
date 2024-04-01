import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object MySever {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem(Behaviors.empty, "mySystem")
    // 最後のflatMap/onCompleteのために必要になるみたい
    implicit val executionContext: ExecutionContext = system.executionContext

    val route =
      path("misezan") {
        parameters("arg1".as[Int], "arg2".as[Int]) { (arg1, arg2) =>
          val misezan = new Misezan()
          val result: Double = misezan.calculate(arg1, arg2)
          complete("眼は" + result.toString + "です\n")
        }
      }

    val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // リターンキーを押すまで稼働
    bindingFuture
      .flatMap(_.unbind()) // HTTPサーバーを停止
      .onComplete(_ => system.terminate()) // アクターシステムを終了
  }
}