package lectures.part2oop

object Objects extends App {
  //SCALA DON'T HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person { // type + its only instance
    // "static"/"class" level functionality
    val N_EYES = 2
    def canFly : Boolean = false

    // factory method
    def apply(mother: String, father: String) : Person = new Person("Bobbie")
  }

  class Person(name: String) {
    // instant level functionality
  }
  //COMPANION

  val person1 = Person
  val person2 = Person

  val p1 = new Person("Ram")
  val p2 = new Person("Shyam")

  println(person1.N_EYES)
  println(person1.canFly)

  println(person1 == person2)
  println(p1 == p2)

  val bobbie = Person("marry", "john")
}
