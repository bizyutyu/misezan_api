import rules._

class Misezan(){

    def calculate(arg1: Int, arg2: Int): Int = {
        (arg1, arg2) match {
            case (a, b) if isEqual(a, b) => 0
            case _ => arg1+arg2
        }
    }
}