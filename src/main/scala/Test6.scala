import java.util
import java.util.Date

import akka.actor.FSM.->

import scala.collection.immutable.Queue
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * @Description TODO
  * @Author Yejiezhong
  * @Date 2019/4/29 17:05
  * @Version 1.0
  **/
object Test6 {
  val muList: List[String] = List.empty[String]


  def main(args: Array[String]): Unit = {
    var map1 = Map.empty[Int,(Long,Int)]
    map1 += 1 -> (1,2)
    map1 += 2 -> (2,3)
    println(map1.map(p => (p._1, p._2._1, p._2._2)))

    println(System.currentTimeMillis())
    println(new Date().getTime)
    Array.fill(6){false}.foreach(println)


    val seq: Seq[Int] = Seq(1, 2, 3, 4, 5)
    var list = ListBuffer(1, 2, 3, 4)
    val list3 = list += 9
    //    val list1 = list.insert(2, 23)
    //    val list2 = list +=: "9"
    //    println(list1)
    val iterable: Iterable[Int] = Iterable(1, 2, 3, 4, 5, 6)
    println(list take 3)
    println(list)
    println(iterable)
    println(list3)
    val map = Map(1 -> 2, 3 -> 4)
    println(map.getClass)
    val list4 = List(2, 3, 4)
    val arr = new util.ArrayList[Int]()
    arr.add(2)
    val list5 = list4.tails
    val list6 = ArrayBuffer(9, 8, 7, 6)
    println(list6 - 7)
    val queue = Queue(1, 2, 3, 4)
    println(list6.filter(_ > 7))


    //    val eptList = Map.empty
    //    eptList += "1".asInstanceOf[Int] -> 1
    val a: String = "1"
    println(a.toInt)

    val sa = 4
    sa match {
      case 1 => println(1)
      case 2 | 3 => println(2)
      case 4 | 5 => println(4)
      case _ => throw new Exception
    }

//    try {
//      val a = 10 / 0
//    } catch {
//      case e: Exception => println("exception..."); throw new Exception
//    } finally {
//      println("finally")
//    }
    val astr = "abcd"
    val abyte = astr.getBytes
    println(abyte)

    println("fff")
    println(muList.nonEmpty)
    val asd = if (1 == 2) 1
    else 3
    println(asd)

  }

  //
  //  def strToMap[A, B](str: String, firstSep: String = ",", secondSep: String = "_"): Map[A, B] = {
  //
  //      var result: Map[A, B] = Map.empty
  //            result += item(0).asInstanceOf[A] -> item(1).asInstanceOf[B]
  //      result
  //    }
  //  }


}
