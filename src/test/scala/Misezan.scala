import org.scalatest.flatspec.AnyFlatSpec

class MisezanSpec extends AnyFlatSpec {

  val misezan = new Misezan

  "Misezan_Calc" should "引数を２つ取得し、和を返すことができる" in {
    assert(misezan.calculate(5, 12) == 17)
    assert(misezan.calculate(0, 120) == 120)
    assert(misezan.calculate(53, 12) == 65)
    assert(misezan.calculate(55, 592) == 647)
  }

  it should "引数2つが等しい場合、0を返すことができる" in {
    assert(misezan.calculate(5, 5) == 0)
    assert(misezan.calculate(12, 12) == 0)
    assert(misezan.calculate(100, 100) == 0)
  }
}
