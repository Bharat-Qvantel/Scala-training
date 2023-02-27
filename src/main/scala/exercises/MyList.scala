package exercises

import scala.annotation.tailrec

/*trait MyPredicate[-A] {
    def apply(t: A): Boolean
}

trait MyTransformer[-A, B] {
    def apply(ele: A): B
}*/

abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyList[B]
    def printElements: String
    override def toString(): String = s"[$printElements]"

    // higher-order functions => receives function as parameter or return function
    def filter(predicate: A => Boolean): MyList[A]
    def map[B](transformer: A => B): MyList[B]
    def flatMap[B](transformer: A => MyList[B]): MyList[B]
    def ++[B >: A](list: MyList[B]): MyList[B]
    def foreach(f: A => Unit): Unit
    def sort(compare: (A, A) => Int): MyList[A]
    def zipWith[B,C](list: MyList[B], zip: (A, B) => C): MyList[C]
}

case object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    def printElements: String = ""
    def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
    def map[B](transformer: Nothing => B): MyList[B] = Empty
    def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
    def foreach(f: Nothing => Unit): Unit = () // () is is Unit return type
    def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
    def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
        if(!list.isEmpty) throw new RuntimeException("List do not have the same length.")
        else Empty
    }
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    def printElements: String = {
        if (t.isEmpty) s"$h"
        else s"$h ${t.printElements}"
    }
    def filter(predicate: A => Boolean): MyList[A] = {
        if(predicate(h)) Cons(h, t.filter(predicate))
        else t.filter(predicate)
    }
    def map[B](transformer: A => B): MyList[B] = {
        Cons(transformer(h), t.map[B](transformer))
    }
    def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)

    def flatMap[B](transformer: A => MyList[B]): MyList[B] = 
        transformer(h) ++ t.flatMap(transformer)
    def foreach(f: A => Unit): Unit = {
        f(h)
        t.foreach(f)
    }    
    def sort(compare: (A, A) => Int): MyList[A] = {
  
        def insert(x: A, sortedList: MyList[A]): MyList[A] = {
            if (sortedList.isEmpty) Cons(x, Empty)
            else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
            else Cons(sortedList.head, insert(x, sortedList.tail))
        }

        val sortedTail = t.sort(compare)
        insert(h, sortedTail)
    }
    def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
        if(list.isEmpty) throw new RuntimeException("List do not have the same length.")
        else Cons(zip(h, list.head), t.zipWith(list.tail, zip))
    }
}

object ListTest extends App {
    val list: MyList[Int] = Cons(1,  Cons(2, Empty))
    val listOfStrings: MyList[String] =  Cons("Scala",  Cons("lang", Empty))
    println(list.toString)
    println(listOfStrings.toString())
    val listWith3Elements = list.add(0)
    val listOfStringsWith3Elements = listOfStrings.add("Hello")

    println(listWith3Elements.filter((t: Int) => t%2==0).toString())
    
    println(listWith3Elements.map[Int]((ele: Int) => ele * 2).toString())

    println(listWith3Elements.flatMap((ele: Int) => Cons(ele, ( Cons[Int]((ele + 1),Empty)))).toString())

    println(listOfStringsWith3Elements.toString())

    listOfStringsWith3Elements.foreach((x: String) => println(x))

    val unsortedList: MyList[Int] = Cons(4, Cons(2, Cons(5, Cons(1, Cons(3, Empty)))))
    println(unsortedList.sort((x: Int, y: Int) => x - y).toString())

    println(listWith3Elements.zipWith[String, String](listOfStringsWith3Elements, _ + "-" + _).toString())
}
