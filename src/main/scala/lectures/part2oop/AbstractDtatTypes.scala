package lectures.part2oop

object AbstractDtatTypes extends App {

  // abstract  
  abstract class Animal {
    val creatureType : String
    def eat : Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "domestic"
    def eat: Unit = println("Dog is eating")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal) : Unit
  }

  trait ColdBlood

  class Crocodile extends Animal with Carnivore with ColdBlood {
    override val creatureType: String = "wild"
    def eat = println("Crocodile is eating!")
    def eat(animal: Animal): Unit = println(s"I am a Crocodile and I am eating a ${animal.creatureType}")
  }

  val croc = new Crocodile()
  val dog : Animal = new Dog()
  croc.eat(dog)
}
