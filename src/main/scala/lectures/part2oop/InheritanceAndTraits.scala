package lectures.part2oop

object InheritanceAndTraits extends App {

    // single class inheritance
  class Animal {
    val cretureType = "wild"
    def eat = println("Eating!")
  }

  class Cat extends Animal {
    def crunch = {
        eat
        println("Crunching")
    }
  }

  val cat = Cat()
  cat.crunch

  // constructors
  class Person(name : String, age : Int) {

  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val cretureType: String) extends Animal {
    override def eat: Unit = {
        super.eat
        println("Dog Eating")
    }
  }

  val dog = Dog("domestic")
  dog.eat
  println(dog.cretureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal : Animal = new Dog("wild")
  unknownAnimal.eat

  // preventing override
  // 1 - use final on the particular method
  // 2 - use final on the entire class
  // 3 - seal the calss - you can't extend the class in other filess

}
