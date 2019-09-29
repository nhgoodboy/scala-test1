package scalaTest

import java.util.Date

import scala.collection.mutable

class Test5(val a: String, val b: String) {

  private val c = "asd"
  private var d = "asdf"

  def getA(): String = {
    a
  }

}

//class Test6 {
//  private val d = "d"
//}

object Test5 {

  val e = "e"

  def main(args: Array[String]): Unit = {
    val ccc = 1561561019000L
    val ddd = 1568197907365L
    val eee = 1568707099000L
    println(new Date(eee).toString)
    println((ddd -ccc) / 1000 / 60 /60 /24)
    val set = mutable.Set((1,3),(54,4),(6,6),(3,0),(7,9))
    println(set.toList)
    val list = set.toList.sortBy(_._2)
    set.foreach(i => {
      println(i)
      if (i._2 > 3) {
        set -= i
        println(set.size)
      }
    })
    println(set.toList.sortBy(_._2))
    println(set.toList)
  }

  def printlnA(): Unit = {
    println(packC)
  }
}
