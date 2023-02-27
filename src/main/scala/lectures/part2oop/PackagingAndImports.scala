package lectures.part2oop

import lectures.part2oop.AbstractDtatTypes.Animal
import exercises.{Cons, Empty => Vacant}

object PackagingAndImports extends App {
    // package members are accessible by their simple name
    val animal = new Counter(1)

    // import the package
    val em = Cons[Int](1, Vacant)

    // packages are in hierarchy
    // matching folder structure

    // package object
    sayHello
    println(SPEED_OF_LIGHT)
}
