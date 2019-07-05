package scalaTest

import scala.collection.JavaConversions._
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by 80635 on 2019/3/16.
  */
class ApplyTest(foo: String) {
}

object ApplyTest {
  def apply(foo: String): ApplyTest = {
    new ApplyTest(foo)
  }

  def testDef[T](foo: T => String): Unit = {
    println(foo)
  }

  def testDee(str: Int): String = {
    str.toString
  }

  def main(args: Array[String]) {
    testDef(testDee)


    val foo = ApplyTest("hello")
    println(foo)

    val array = List(1, 2, 3)
    array.foreach(x => print(x + " "))

    val command = ArrayBuffer("ls", "-al", "/home/cay")
    val pb = new ProcessBuilder(command)
    println(pb)
    val str = "<"
    println(str * 2)

    val tuple = Tuple3(1, 2, 3)
    println(tuple._2)

    var a1 = List(1, 2, 3, 4, 5)
    a1 ::= 6
    println(a1)
    println(a1.find(v => v == 3).head)
    println(a1.filter(v => v == 3).head)

    var map1 = Map(1 -> "a", 2 -> "b")
    var map2 = Map(3 -> "c", 4 -> "d")
    var (a11, b11) = (1, 2)
    println(a11)
    println(b11)
    //        var map1And2 = a1 ::= map2

    var map = mutable.Map.empty[Int, Int]
    map += 1 -> 1
    map += 1 -> 2
    map += 2 -> 3
    println(map)
    println("type")
  }
}
