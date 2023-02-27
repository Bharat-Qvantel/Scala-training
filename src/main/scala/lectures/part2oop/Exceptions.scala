package lectures.part2oop

object Exceptions extends App {
  
    def getInt(withExceptions: Boolean): Int = {
        if (withExceptions) throw new RuntimeException("No int for you")
        else 42
    }

    try {
        getInt(true)
    } catch {
        case e: NullPointerException => println("Caught a runtime exception")
    } finally {
        println("finally")
    }

    class MyException extends Exception
    val exception = new MyException

    class OverflowException extends Exception
    class UnderflowException extends Exception
    class MathCalculationException extends RuntimeException("Divident can't be zero")

    object PocketCalculator {
        def add(x: Int, y: Int): Int = {
            val result = x + y
            if (x>0 && y>0 && result<0) throw new OverflowException 
            else if (x<0 && y<0 && result>0) throw new UnderflowException
            else result
        }

        def subtract(x: Int, y: Int): Int = {
            val result = x - y
            if (x > 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result
        }

        def multiply(x: Int, y: Int): Int = {
            val result = x * y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result < 0) throw new OverflowException
            else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result
        }

        def divison(x: Int, y: Int): Int = {
            if (y == 0) throw new MathCalculationException
            else x/y
        }
    }

    println(PocketCalculator.add(Int.MaxValue, 0))
}
