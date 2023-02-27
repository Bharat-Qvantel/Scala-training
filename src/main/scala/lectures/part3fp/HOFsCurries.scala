package lectures.part3fp

object HOFsCurries extends App {

    //val superFunnction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
    // higher order functions HOFs

    // map, filter, filterMap in MyList

    // function that appilies a function n times over a value x
    // nTimes(f, n, x)
    // nTimes(f, 3, x) => f(f(f(x)))

    def nTimes(f: Int => Int, n: Int, x: Int): Int = {
        if (n <= 0) x
        else nTimes(f, n-1, f(x))
    }

    val double: (Int => Int) = _*2

    println(nTimes(_*2, 3, 1))

    val plus = (x: Int) => x+1

    def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
        if(n<=0) (x: Int) => x
        else (x: Int) => nTimesBetter(f, n-1)(f(x))
    }

    val plus10 = nTimesBetter(plus, 10)
    println(plus10(1))

    // curried function
    val superAdder: Int => (Int => Int) = (v11: Int) => (v1: Int) => v1 + v11
    val add3 = superAdder(3)
    println(add3(10))
    println(superAdder(3)(10))

    // functions with mulitple parameters lists
    def curriedFormater(c: String)(x: Double): String = c.format(x)

    val standardFormat: (Double => String) = curriedFormater("%4.2f")
    val preciseFormat: (Double => String) = curriedFormater("%10.8f")

    println(standardFormat(Math.PI))
    println(preciseFormat(Math.PI))

    /*
     1. foreach method A => Unit
        [1,2,3].foreach(x => println(x))
    */

    def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = ???
}
