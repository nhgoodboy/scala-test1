package scalaTest.bean

import java.time.LocalTime

import scala.collection.JavaConversions._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object IterableTest {



  def main(args: Array[String]): Unit = {
    Future {
      Thread.sleep(10000)
      println(s"This is the future at ${LocalTime.now}")
    }
    Thread.sleep(1000)

    println(s"That is the future at ${LocalTime.now}")
    //    val list1 = List(List(1, 2, 3), List(4, 5, 6))
    //
    //    val i = 10
    //    println((1 to i).map(j => i * j))
    //    val a = (1 to 10).flatMap(i => (1 to i).map(j => i * j))
    //    println(a)
    //
    //    val b = for (i <- 1 to 10; j <- 1 to i) yield i * j
    //    println(b)
    //
    //    val map = scala.collection.mutable.Map(1 -> 1, 2 -> 2, 3 -> 3)
    //    map(3) = map.getOrElse(3, 0) + 1
    //    println(map)
    //    map(5) = 5
    //    println(map)

//    val list2 = List(1, 2, 3, 4, 5, 6, 7, 8)
//    println(list2.grouped(7).foreach(println))
//    println(list2.sliding(7).foreach(println))
//
//    val tenOrMore = numsFrom(10)
//    println(tenOrMore.take(5).force)
//
//    val palindromicSquares = (1 to 10000).view.map(x => x * x).filter(x => x.toString == x.toString.reverse)
//    println(palindromicSquares.take(10).mkString(","))
//
//    val props: scala.collection.mutable.Map[String, String] = System.getProperties()
//
//    val coll = List(1 to 1000)
//    for (i <- (0 until 1000).par) {
//      print(s" $i")
//    }
    val map = Map("1"->1, "2"->2, "3"->3)
    map.filter( x => x._1 == 1 )

  }

  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

}


