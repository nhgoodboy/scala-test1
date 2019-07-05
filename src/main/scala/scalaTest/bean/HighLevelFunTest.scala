package scalaTest.bean

class HighLevelFunTest {


}

object HighLevelFunTest {

  val vvv = 1

  def mulBy(factor: Double): Double => Double = (x: Double) => factor * x

  def main(args: Array[String]): Unit = {
    //    val obj = new HighLevelFunTest
    println(mulBy(5)(3))

    println((1 to 9).map(0.1 * _))
    (1 to 9).map("*" * _).foreach(println)
    (1 to 9).filter(_ % 2 == 0)
    "Mary had a little lamb".split(" ").sortWith(_.length < _.length).foreach(println)

    val triple = mulBy(3)
    val half = mulBy(0.5)
    println(s"${triple(14)} ${half(14)}")


    val mul = (x: Int, y: Int) => x * y
    val mulOneAtATime = (x: Int) => (y: Int) => x * y
    mulOneAtATime(6)(7)
    println(mulOneAtATime2(6)(9))

    //    runInThread {
    //      println("Hi")
    //      Thread.sleep(10000)
    //      println("Bye")
    //    }

    var x = 10
    until(x == 0) {
      x -= 1
      println(x)
    }

    println(digits(102348952))

    val list: List[Int] = List(1, 2)
    println(list.tail.tail == Nil)
    println(sum(List(1, 2, 3, 4)))

    println(2 + "3")
    println(2 :: List(3,4,5))
    println(List(3,4,5) :+ 2)
  }

  def vvvv(): Int = {
    1
  }

  def mulOneAtATime2(x: Int)(y: Int): Int = x * y

  def runInThread(block: => Unit): Unit = {
    new Thread {
      override def run(): Unit = {
        block
      }
    }.start()
  }

  def until(condition: => Boolean)(block: => Unit): Unit = {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until(i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    -1
  }

  def digits(n: Int): Set[Int] = {
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n / 10) + (n % 10)
  }

  def sum(lst: List[Int]): Int = lst match {
    case Nil => 0
    case h :: t => h + sum(t)
  }
}