package lectures.part3fp

object AnonymousFunction extends App {

    val doubler = (x: Int) => x.toString()

    val adder = (a: Int, b: Int) => a + b

    val justDoSomething = () => 3

    // carefull
    println(justDoSomething) // function itself
    println(justDoSomething()) // call of function

    // curly braces with lambdas
    val stringToInt = {
        (str: String) => str.toInt
    }

    // MORE syntactic sugar
    val niceIncrement: Int => Int = _+1 // equivalent to x => x+1
    val niceAdder: (Int, Int) => Int = _+_ // equivalennt to (a,b) => a + b

    println(niceAdder(99,100))

    /* 
     1. MyList replace all FunctionX calls with lambdas
     2. Rewrite the special adder as an anonymous function
    */
}
