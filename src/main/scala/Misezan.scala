import rules.AppliedJudgeRule

class Misezan(){

    val ajr = new AppliedJudgeRule()

    def calculate(num1: Int, num2: Int): Double = {
        (ajr.isEqual(num1,num2), ajr.isCombination2and5(num1, num2), ajr.isCombination6and9(num1, num2), ajr.is100TimesOrOver(num1, num2)) match {
            case (true, _, _, _) => 0.0
            case (false, true, _, _) => 1.1
            case (false, _, true, _) => 11.0
            case (false, _, _, true) => 
                if (ajr.isLargeFirstArgument(num1, num2)) num1 - (num2 * 17)
                else num2 - (num1 * 17)
            case _ => this.returnLargeNumber(num1, num2).toDouble
        }
    }
    
    private def returnLargeNumber(num1: Int, num2: Int): Int = {
        if (num1 > num2) num1
        else num2
    }
}
