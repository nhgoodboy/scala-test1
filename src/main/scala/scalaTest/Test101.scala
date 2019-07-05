package scalaTest

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @Description TODO
  * @Author Yejiezhong
  * @Date 2019/4/28 20:24
  * @Version 1.0
  **/
object Test101 {

  def main(args: Array[String]): Unit = {
    val map = List(mutable.HashMap(("a", 1), ("b", 2)))
    map.find(i => i("b") == 2) match {
      case None =>
      case Some(v) => v("b") = 3; println(map)
    }

    val list = List[mutable.Map[Int, Int]](mutable.Map(6 -> 6), mutable.Map(7 -> 7))
    var mutableList: ListBuffer[mutable.Map[Int, Int]] = ListBuffer(mutable.Map(1 -> 1), mutable.Map(2 -> 2))
    mutableList ++= list
    println(mutableList)
    mutableList(2) = mutable.Map(10 -> 10)
    println(mutableList)
    println(mutableList.getClass)
    test1("a", "b")

    println("-----------------------")
    val abcd = Seq('a', 'b', 'c', 'd')
    println(abcd.flatMap(ch => List(ch.toUpper, ch)))
    val numbers = Seq(3, 7, 2, 9, 6, 5, 1, 4, 2)
    println(numbers.forall(_ < 10))
    println(numbers.filter(_ < 5))
    println(numbers.partition(n => n % 2 == 0))
    println(numbers.foldLeft(0)((res, n) => res + n))
    println(numbers.max)
  }

  def test1(str1: => Any): Unit = {
    println(str1.getClass)
  }
}
