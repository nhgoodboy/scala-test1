import scala.collection.mutable
import scala.reflect.ClassTag

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/5/30 16:56
  **/
class ScalaArrayDemo[T] {

  private val secret = 2

  var a = 1

  def makeTArray[T: ClassTag](): Array[T] = new Array[T](10)

}

object ScalaArrayDemo {

  //  def double(foo: )

  def main(args: Array[String]): Unit = {
    val bigA: BigDecimal = 999999999
    val ccd = bigA * 123
    println(BigInt)
    println(ccd)
    println(ccd.toInt)
    println(ccd.isValidInt)
//    val aArr = Array(1,2,3,3,3,3,3,4,5)
//    val bArr = Array(3,4,5,6,7)
//    println(aArr.diff(bArr).getClass)
//
//
//    val task = new Task(1,2,3)
//
//    val a = List[Int](20)
//    val b = new ScalaArrayDemo[Int].makeTArray()
//    val c = Array(20, 30, 40, "20")
//    println(a.isInstanceOf[List[Int]])
//    println(b.isInstanceOf[Array[Int]])
//    println(c.isInstanceOf[Array[Int]])
//
//    println(List(("a", "b", "c", 1), ("a", "b", "c", 2), ("a", "b", "c", 3), ("a", "b", "c", 5)).toString())
//    println(List(("a", "b", "c", 1), ("a", "b", "c", 2), ("a", "b", "c", 3), ("a", "b", "c", 5)))
//
//    val set1 = Set(1, 2, 3, 4, 5)
//    println(set1)
//    println(set1.head)
//    println(set1.tail)
//
//    val d = new ScalaArrayDemo[Int]
//    val e = d
//    e.a = 2
//    println(e.a)
//    println(d.a)
//    println(Int.MaxValue)
//    println(Int.MaxValue.toDouble / 10 / 60 / 60 / 24)
//
//    val prio = mutable.PriorityQueue[Int]()(Ordering.fromLessThan((x: Int, y: Int) => x < y))
//    val arr = Array(2, 3, 1, 5, 8, 7, 0)
//    arr.foreach(i => prio += i)
//    while (prio.nonEmpty) {
//      println(prio.dequeue())
//    }
  }
}

/**
  * 提额任务
  */
class Task(var id: Int,
           var status: Int, //(0:未达成, 1:待领取, 2:已领取)
           var curProgress: Int //当前进度
          ) {
}