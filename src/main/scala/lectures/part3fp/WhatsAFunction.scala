package lectures.part3fp

object WhatsAFunction extends App {
    // DREAM: use function as a first class element
    // problem: oop

    val doubler = new MyFunction[Int, Int] {
        override def apply(element: Int): Int = element * 2
    }

    println(doubler(2))

    // function types = Function[A,B]
    val stringToIntConverter = new Function1[String, Int] {
        override def apply(s: String): Int = s.toInt
    }

    println(stringToIntConverter("3") + 7)

    // Function2[Int,Int,Int] = ((Int, Int) => Int)
    val adder: ((Int, Int) => Int) = new Function2[Int,Int,Int] {
        override def apply(v1: Int, v2: Int): Int = v1 + v2
    }

    println(adder(9,3))

    /*
     1. A funciton which takes two strings and concatenate them
     2. Transform MyTransformer and MyPredicate into function types
    */

    // 1. A funciton which takes two strings and concatenate them
    val conc = new Function2[String, String, String] {
        override def apply(v1: String, v2: String): String = v1 + v2
    }

    println(conc("Bharat ", "Jain"))

    val add = (v1: Int) => v1 +5

    /* val superAdder = new Function1[Int, Int => Int] {
        override def apply(v11: Int): Int => Int = new Function1[Int, Int] {
            override def apply(v1: Int): Int = v1 + v11
        }
    } */

    val superAdder = (v11: Int) => (v1: Int) => v1 + v11

    println(superAdder(3)(4)) // curried function
}

trait  MyFunction[A, B] {
    def apply(element: A): B
}
