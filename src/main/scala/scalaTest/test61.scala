package scalaTest

import java.util.{Calendar, Date}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/6/1 10:32
  **/
object test61 extends App {

  val list65 = List("123", "456", "789")
  println(list65.mkString(","))

  println((8.0 / 100 * 60).toInt)

  println((new test61_f).a)
  println((new test61_s).a)

  var fruits = ArrayBuffer("apple")

  val addToBasket = (s: String) => {
    fruits += s
    println(fruits.mkString(","))
  }
  addToBasket("orange")
  fruits = ArrayBuffer("banana")
  addToBasket("orange")

  val sum = (a: Int, b: Int, c: Int) => a + b + c
  val f = sum(1, 2, _)
  println(f)
  println(f(4))

  val divide = new PartialFunction[Int, Int] {
    override def apply(v1: Int): Int = {
      42 / v1
    }

    override def isDefinedAt(x: Int): Boolean = {
      x != 0
    }
  }

  println(divide.isDefinedAt(0))

  var emptyArr = ArrayBuffer[Int]()
  println(emptyArr)

  var emptyArr2 = ArrayBuffer.empty[Int]
  println(emptyArr2)
  println(emptyArr == emptyArr2)

  println(Integer.MAX_VALUE)
  println(Double.MaxValue)
  println(Float.MaxValue)
  println(Long.MaxValue)
  println(Int.MaxValue / 60 / 60 / 24)

  var list1 = ListBuffer.empty[Int]
  val start1 = System.currentTimeMillis()
  for (i <- 1 to 10000000) {
    list1 += i
  }
  println(System.currentTimeMillis() - start1)

  var list2 = ArrayBuffer.empty[Int]
  val start2 = System.currentTimeMillis()
  for (i <- 1 to 10000000) {
    list2 += i
  }
  println(System.currentTimeMillis() - start2)

  var list3 = List.empty[Int]
  val start3 = System.currentTimeMillis()
  for (i <- 1 to 10000000) {
    (i +: list3).reverse
  }
  println(System.currentTimeMillis() - start3)

  val arr63: List[Int] = Nil
  println(arr63.isEmpty)

  val arr543 = List.empty[Int]
  arr543.foreach(a => {
    println(a)
  })

  def differentDaysDivide(date1: Date, date2: Date, divide : Int = 0): Int = {
    val cal1 = Calendar.getInstance()
    cal1.setTime(date1)
    val cal2 = Calendar.getInstance()
    cal2.setTime(date2)
    if(cal1.get(Calendar.HOUR_OF_DAY) < divide) cal1.add(Calendar.DAY_OF_YEAR, -1)
    if(cal2.get(Calendar.HOUR_OF_DAY) < divide) cal2.add(Calendar.DAY_OF_YEAR, -1)
    cal1.set(Calendar.HOUR_OF_DAY, divide)
    cal1.clear(Calendar.MINUTE)
    cal1.clear(Calendar.SECOND)
    cal1.clear(Calendar.MILLISECOND)
    cal2.set(Calendar.HOUR_OF_DAY, divide)
    cal2.clear(Calendar.MINUTE)
    cal2.clear(Calendar.SECOND)
    cal2.clear(Calendar.MILLISECOND)
    ((cal2.getTimeInMillis - cal1.getTimeInMillis) / (24 * 60 * 60 * 1000)).toInt
  }
//  println(differentDaysDivide(new Date(), ))


}

class test61_f {
  val a = 2
}

class test61_s extends test61_f {
  override val a = 3


  def fun1(): this.type = {
    this
  }
}

class Person(var name: String) extends Ordered[Person] {
  override def compare(that: Person): Int = {
    1
  }
}