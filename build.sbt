name := "misezan-api"

version := "0.1"

scalaVersion := "2.13.3"

ThisBuild / scalacOptions ++= Seq("-Wunused:imports")

inThisBuild(
  List(
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision
  )
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.6.10",
  "com.typesafe.akka" %% "akka-http" % "10.2.0",
  "com.typesafe.akka" %% "akka-stream" % "2.6.10",
  "com.typesafe.play" %% "play-json" % "2.9.2",
  "org.scalatest" %% "scalatest" % "3.2.18" % "test",
  "org.scalatest" %% "scalatest-flatspec" % "3.2.18" % "test"
)