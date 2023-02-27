package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int = 0){
    def likes(movie: String) : Boolean = movie == favouriteMovie
    def +(person: Person) : String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String) : Person = new Person(s"${this.name} ($nickname)", favouriteMovie)

    def unary_! : String = s"$name what the heck!"

    def unary_+ : Person = new Person(name,  favouriteMovie, age + 1)

    def apply() : String = s"Hi my name is $name and I like $favouriteMovie movie"

    def apply(times: Int) = s"$name watch movie $times times"

    def learns(lang: String) : String = s"$name learns $lang"

    def learnScala : String = learns("Scala")
  }

  val p1 = new Person("Tom", "SpiderMan")
  val p2 = new Person("Jerry", "Ironman")

  // operators in scala
  // infix notation == operator notation (syntatic sugar)
  println(p1 likes "SpiderMan")
  println(p1 + p2)

  // ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!p1)
  // equivalent
  println(p1.unary_!)

  // apply method
  println(p1())

  println((p1 + "person1").apply())
  println(p1(2))

  println(p1.age)
  println((+p1).age)

  println(p1.learnScala) // postfix notations are not working

}
