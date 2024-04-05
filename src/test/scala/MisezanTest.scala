import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class MisezanSpec extends AnyFlatSpec with Diagrams {

  val misezan = new Misezan

  "Misezan_Calc" should "引数2つが等しい場合、0を返すことができる" in {
    assert(misezan.calculate(5, 5) == 0)
    assert(misezan.calculate(100, 100) == 0)
    assert(misezan.calculate(-1, -1) == 0)
  }

  it should "2か5の両方もしくはいずれかで構成されるかつ桁数が同じ場合、1.1を返すことができる" in {
    assert(misezan.calculate(2, 5) == 1.1)
    assert(misezan.calculate(25, 52) == 1.1)
    assert(misezan.calculate(225, 522) == 1.1)
  }

  it should "6か9の両方もしくはいずれかで構成されるかつ桁数が同じ場合、11を返すことができる" in {
    assert(misezan.calculate(6, 9) == 11)
    assert(misezan.calculate(69, 96) == 11)
    assert(misezan.calculate(669, 966) == 11)
  }

  it should "一方がもう一方の100倍以上の場合、【(大きい方の数字)-(少ない方の数字x17)】を返すことができる" in {
    assert(misezan.calculate(100, 1) == 83)
    assert(misezan.calculate(1, 100) == 83)
    assert(misezan.calculate(1700, 10) == 1530)
  }

  it should "例外を除く、違う数字同士の場合、大きい方を返すことができる" in {
    assert(misezan.calculate(1, 2) == 2)
    assert(misezan.calculate(100, 99) == 100)
    assert(misezan.calculate(221, 555) == 555)
  }
}
