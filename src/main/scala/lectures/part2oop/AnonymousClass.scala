package lectures.part2oop

object AnonymousClass extends App {

    abstract class Animal {
        def eat: Unit
    }

    // anonymous class
    val funnyAnimal = new Animal {
        override def eat: Unit = println("hahahahahahaha")
    }

    class Person(name: String) {
        def sayHi: Unit = s"Hi my name is $name how can I help you"
    }

    val person = new Person("Jim") {
        override def sayHi: Unit = s"Hi my name is Jim how can help you"
    }
}
