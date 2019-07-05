package scalaTest

import java.util.Calendar

/**
  * Created by 80635 on 2019/3/16.
  */
object EnumerationTest extends Enumeration {
  type EnumrationTest = Value
  val Red, Yellow, Blue, Black = Value


  def main(args: Array[String]) {
    println(EnumerationTest.Black.id)
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    println(hour)
    println(calendar.get(Calendar.HOUR))
    val arr = Array(5,4,3,6)
    println(arr(1))
  }
}

case class caseClz(var a: Int)