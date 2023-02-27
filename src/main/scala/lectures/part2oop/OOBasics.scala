package lectures.part2oop
object OOBasics extends App {
  val person = new Person("Bharat", 21)
  println(person.x)
  person.greet("Amit")
  person.greet()

  val author = new Writer("Hector", "Garcia", 1990)
  val novel = new Novel("Ikigai", 1999, author)

  println(author.fullname())
  println(novel.authorage())
  println(novel.isWrittenBy(author))
  val revised_novel = novel.copy(2001)
  println(revised_novel.authorage())

  val counter = new Counter
  println(counter.currentCount())
  println(counter.increment(10).currentCount())
}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2
  println(1+3)

  // method
  def greet(name: String) : Unit = println(s"${this.name} is saying Hi $name")

  // overloading
  def greet(): Unit = println(s"Hello $name")

  def this(name: String) = this(name, 0)

  def this() = this("Amit Karahe")
}

// class parameters are not fields
// Everything in the class is executed 


class Writer(first_name: String, surname: String, val year: Int){
  def fullname() : String = first_name + " " + surname
}

class Novel(name: String, year_of_release: Int, author: Writer){
  def authorage() : Int = year_of_release - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(new_year: Int) : Novel = new Novel(name, new_year, author)
}

class Counter(x: Int = 0){
  def currentCount() : Int = x
  def increment : Counter = {
    println("Incremennting")
    new Counter(x + 1) // immutability
  }
  def decrement : Counter = {
    println("Decrementing")
    new Counter(x - 1)
  }
  def increment(amount: Int) : Counter = {
    if (amount <= 0) this
    else increment.increment(amount - 1)
  }
  def decrement(amount: Int) : Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount - 1)
  }
}