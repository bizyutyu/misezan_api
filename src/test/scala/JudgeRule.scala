import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec
import rules.JudgeRule

class JudgeRuleSpec extends AnyFlatSpec with Diagrams {

  val jrule = new JudgeRule

  "JudgeRule_isEqual" should "引数2つが等しい場合、trueを返すことができる" in {
    assert(jrule.isEqual(5, 5) == true)
    assert(jrule.isEqual(2147483647, 2147483647) == true)
    assert(jrule.isEqual(-1, -1) == true)
  }

  it should "引数2つが異なる場合、falseを返すことができる" in {
    assert(jrule.isEqual(2, 5) == false)
    assert(jrule.isEqual(25, 52) == false)
    assert(jrule.isEqual(225, 522) == false)
  }

  "JudgeRule_isLargeFirstArgument" should "第一引数の数字のほうが大きい場合、trueを返すことができる" in {
    assert(jrule.isLargeFirstArgument(100, 5) == true)
    assert(jrule.isLargeFirstArgument(2147483647, 100) == true)
    assert(jrule.isLargeFirstArgument(5, -10) == true)
  }

  it should "第一引数の数字のほうが大きくない場合、falseを返すことができる" in {
    assert(jrule.isLargeFirstArgument(2, 5) == false)
    assert(jrule.isLargeFirstArgument(25, 52) == false)
    assert(jrule.isLargeFirstArgument(225, 522) == false)
  }
}
