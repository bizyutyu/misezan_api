package rules

class JudgeRule(){
    
    // 数字が等しいかどうか
    def isEqual(num1: Int, num2: Int): Boolean = {
        num1 == num2
    }
    
    // 第一引数の数字のほうが大きいかどうか
    def isLargeFirstArgument(num1: Int, num2: Int): Boolean = {
        num1 > num2
    }
}
