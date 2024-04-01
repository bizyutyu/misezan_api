package rules

class AppliedJudgeRule() extend JudgeRule{

    // 2か5の両方もしくはいずれかで構成されるかつ桁数が同じ数字同士かどうか
    def isCombination2and5(num1: Int, num2: Int): Boolean = {
        // パターンマッチ
        (this.isSameNumberOfDigits(num1, num2), this.areAllDigitsXY(2 ,5 ,num1), this.areAllDigitsXY(2, 5, num2)) match {
            case (true, true, true) => true // 全部満たす場合にtrue
            case (false, _, _) => false // 桁数が異なる場合はfalse
            case _ => false // それ以外はfalse
        }
    }
    
    // 6か9の両方もしくはいずれかで構成されるかつ桁数が同じ数字同士かどうか
    def isCombination6and9(num1: Int, num2: Int): Boolean = {
        // パターンマッチ
        (this.isSameNumberOfDigits(num1, num2), this.areAllDigitsXY(6, 9, num1), this.areAllDigitsXY(6, 9, num2)) match {
            case (true, true, true) => true // 全部満たす場合にtrue
            case (false, _, _) => false // 桁数が異なる場合はfalse
            case _ => false // それ以外はfalse
        }
    }

    // 一方がもう一方の100倍以上かどうか
    def is100TimesOrOver(num1: Int, num2: Int): Boolean = {
        num1 / num2 >= 100 || num2 / num1 >= 100
    }
    
    // 桁数が同じかどうか
    private def isSameNumberOfDigits(num1: Int, num2: Int): Boolean = {
        // toIntによって切り捨てが行われるので+1する
        // 現状はプライスマイナスの区別をしていない
        // 今度対応したい
        val digitsNum1 = if (num1 == 0) 1 else math.log10(math.abs(num1)).toInt + 1
        val digitsNum2 = if (num2 == 0) 1 else math.log10(math.abs(num2)).toInt + 1
        digitsNum1 == digitsNum2
    }

    // 与えられた数字のすべての桁が与えられた２つの数字から成るか
    // リストを使えば数字の数を気にしなくて良くなるがやってない
    private def areAllDigitsXY(c1: Int, c2: Int, num: Int): Boolean = {
        num.toString.forall(c => c == c1.toChar || c == c2.toChar)
    }

    // private def isPlus(num: Int): String = {
    //     if (num > 0) {
    //         "正の数です"
    //     } else if (num < 0) {
    //         "負の数です"
    //     } else {
    //         "ゼロです"
    //     }
    // }
}