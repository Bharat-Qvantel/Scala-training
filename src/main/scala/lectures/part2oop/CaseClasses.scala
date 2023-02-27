package lectures.part2oop

object CaseClasses extends App {
  /*
    equals, hashCode, toString
  */

  case class Person(name: String, age: Int)

  // 1. Class parameters are fields
  val jim1 = new Person("Jim", 32)
  println(jim1.name)

  // 2. Sensible toString
  println(jim1)

  // 3. equal and hashCode implemented OOTB
  val jim2 = new Person("Jim", 32)
  println(jim1 == jim2)

  // 4. It have handy copy method
  val jim3 = jim2.copy(age = 50)
  println(jim3)

  // 5. It have companian objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. They are serializable
  // Akka

  // 7. It have extrator patterns = It can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
