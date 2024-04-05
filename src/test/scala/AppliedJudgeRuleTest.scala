import org.scalatest.PrivateMethodTester
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import rules.AppliedJudgeRule

class AppliedJudgeRuleSpec
    extends AnyFlatSpec
    with Diagrams
    with Matchers
    with PrivateMethodTester {

  val ajrule = new AppliedJudgeRule

  "AppliedJudgeRule_isCombination2and5" should "2か5の両方もしくはいずれかで構成されるかつ桁数が同じ数字同士の場合、trueを返すことができる" in {
    assert(ajrule.isCombination2and5(2, 5) == true)
    assert(ajrule.isCombination2and5(5, 2) == true)
    assert(ajrule.isCombination2and5(5252525, 5552552) == true)
    assert(ajrule.isCombination2and5(555, 555) == true)
  }

  it should "2か5の両方もしくはいずれかで構成されるかつ桁数が同じ数字同士でない場合、falseを返すことができる" in {
    assert(ajrule.isCombination2and5(2, 22) == false)
    assert(ajrule.isCombination2and5(2222, 5256) == false)
    assert(ajrule.isCombination2and5(225, 2147483647) == false)
    assert(ajrule.isCombination2and5(555222, 2255) == false)
  }

  "AppliedJudgeRule_isCombination6and9" should "6か9の両方もしくはいずれかで構成されるかつ桁数が同じ数字同士の場合、trueを返すことができる" in {
    assert(ajrule.isCombination6and9(6, 9) == true)
    assert(ajrule.isCombination6and9(9, 6) == true)
    assert(ajrule.isCombination6and9(9696969, 9996669) == true)
    assert(ajrule.isCombination6and9(999, 999) == true)
  }

  it should "6か9の両方もしくはいずれかで構成されるかつ桁数が同じ数字同士でない場合、falseを返すことができる" in {
    assert(ajrule.isCombination6and9(6, 66) == false)
    assert(ajrule.isCombination6and9(6666, 5234) == false)
    assert(ajrule.isCombination6and9(669, 2147483647) == false)
    assert(ajrule.isCombination6and9(666999, 9966) == false)
  }

  "AppliedJudgeRule_is100TimesOrOver" should "一方がもう一方の100倍以上の場合、trueを返すことができる" in {
    assert(ajrule.is100TimesOrOver(1, 100) == true)
    assert(ajrule.is100TimesOrOver(2147483647, 100) == true)
    assert(ajrule.is100TimesOrOver(1000, 10) == true)
  }

  it should "一方がもう一方の100倍未満の場合、falseを返すことができる" in {
    assert(ajrule.is100TimesOrOver(1, 99) == false)
    assert(ajrule.is100TimesOrOver(21, 1) == false)
    assert(ajrule.is100TimesOrOver(444, 522) == false)
  }

  "AppliedJudgeRule_isSameNumberOfDigits" should "桁数が同じ場合、trueを返すことができる" in {
    val isSNDig = PrivateMethod[Boolean]('isSameNumberOfDigits)
    ajrule.invokePrivate(isSNDig(25, 22)) shouldBe true
    ajrule.invokePrivate(isSNDig(254, 392)) shouldBe true
    val result = ajrule.invokePrivate(isSNDig(2, 2))
    println(s"結果は${result}\n\n\n\n\n\n")
  }

  it should "桁数が異なる場合、falseを返すことができる" in {
    val isSNDig = PrivateMethod[Boolean]('isSameNumberOfDigits)
    ajrule.invokePrivate(isSNDig(25, 5)) shouldBe false
    ajrule.invokePrivate(isSNDig(254, 2147483647)) shouldBe false
    ajrule.invokePrivate(isSNDig(2, -100)) shouldBe false
  }

  "AppliedJudgeRule_areAllDigitsXY" should "第3引数として与えられた数字のすべての桁が、第1・第2引数で与えられた2つの数字の組み合わせから成る場合、trueを返すことができる" in {
    val areAllDigXY = PrivateMethod[Boolean]('areAllDigitsXY)
    ajrule.invokePrivate(areAllDigXY(2, 5, 52)) shouldBe true
    ajrule.invokePrivate(areAllDigXY(6, 9, 6666)) shouldBe true
    ajrule.invokePrivate(areAllDigXY(5, 0, 5005055)) shouldBe true
    ajrule.invokePrivate(areAllDigXY(2, 5, 2)) shouldBe true
  }

  it should "第3引数として与えられた数字のいずれかの桁に、第1・第2引数で与えられた2つの数字以外が含まれる場合、falseを返すことができる" in {
    val areAllDigXY = PrivateMethod[Boolean]('areAllDigitsXY)
    ajrule.invokePrivate(areAllDigXY(2, 5, 25667)) shouldBe false
    ajrule.invokePrivate(areAllDigXY(6, 9, 85243)) shouldBe false
    ajrule.invokePrivate(areAllDigXY(0, 5, 1)) shouldBe false
    ajrule.invokePrivate(areAllDigXY(2, 5, 2147483647)) shouldBe false
  }
}
