package scalaTest

import java.util.{Calendar, Date}
import java.util.concurrent.ThreadLocalRandom

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/6/6 19:49
  **/
object test6_6 {
  val a = 3
  val b = 5
  val c = a + b
  val d: (Int, Int) = (0,0)
  final val random = ThreadLocalRandom.current()

  def main(args: Array[String]): Unit = {
    val cal = Calendar.getInstance()
    cal.setTime(new Date)
    val array = Array(7,1,2,3,4,5,6)
    println(array(cal.get(Calendar.DAY_OF_WEEK) - 1))

    println(List(1,2,3,4).filter(i => i != 3))
    println(mutable.SortedSet(1,2,3,4,5,6).toList)
    println(mutable.Set(1,2,3,4,5,6))
    println(List("a","b","c").zipWithIndex)
//    println(26 % 22)
//
//    val tuple1 = (1, 2, 3, 4)
//    println(tuple1.toString())
//
//    val map1 = Map(0 -> 0, 66 -> 1, 99 -> 2)
//    println(Array(1,2,3,4,5).mkString("_"))
//    println(",123214".substring(1))
//    println(d)
//
//    val list = List.empty[test55]
//    list.find(i => i.a == 6) match {
//      case None => println("nnn")
//      case Some(v) => println("sss")
//    }
//
//    val stirngddd = new StringBuilder("")
//    println(stirngddd.nonEmpty)
//
//    val list1 = ListBuffer(("a", 0), ("c", 0))
////    list1.foreach(i => i = (i._1, i._2 + 1))
//    val list2 = list1.map(i => (i._1, i._2 + 1))
//    println(list2)
//    println(list1)
//    val tuple111 = (1,3)
//    val tuple222 = (1,3)
//    println(tuple111 == tuple222)
//    val list00 = ListBuffer.empty[(Int,Int)]
//    list00 += ((1,2))
//    println(list00)
//    println(list66)

//    val map1 = mutable.Map("asd" -> new test55)
//    map1.getOrElse("asd", null).a = 8
//    for (i <- 1 to 100) {
//      println(weights_random_2(Array(60, 23, 12, 5)))
//    }

    val map1 = mutable.Map((1,3)->1, (2,6)->1, (3,3)->4, (4,1)->2, (5,0)->0)
//    println(map1.toList.map(i => s"${i._1}_${i._2}").mkString(","))
//
//    var map2 = map1
//    map2 = map2 + (8 -> 8)
//    println(map2)
//
//    var set1 = mutable.Set.empty[Int]
//    println(set1 += 2)
    map1.foreach(m => {
      if (m._1._2 == 3){
        map1.remove(m._1)
      }
    })
    println(map1)

  }

  def weights_random_2(weights: Array[Int]): Int = {
    var total = 0
    for (weight <- weights) {
      total += weight
    }
    val rand = random.nextInt(total)
    var n = 0
    var i = 0
    while (i < weights.length) {
      n += weights(i)
      if (rand < n) {
        return i
      }
      i += 1
    }
    throw new IllegalStateException
  }

}

class test55 {
  var a = 4
  var b = 5
}
