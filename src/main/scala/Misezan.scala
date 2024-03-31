class Misezan(){
    
    def isEqual(num1: Int, num2: Int): Boolean = {
        num1 == num2
    }

    def calculate(arg1: Int, arg2: Int): Int = {
        (arg1, arg2) match {
            case (a, b) if isEqual(a, b) => 0
            case _ => arg1+arg2
        }
    }
}