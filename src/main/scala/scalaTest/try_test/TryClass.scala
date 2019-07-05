package scalaTest.try_test

import scala.util.{Failure, Success, Try}

object TryClass {

  def divideBy(x: Int, y: Int): Try[Int] = {
    Try(x / y)
  }

  def divideBy2(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Dude, can't divide by 0")
    else Right(x / y)
  }

  def main(args: Array[String]): Unit = {
    divideBy(1, 0) match {
      case Success(value) => println(value)
      case Failure(exception) => println(exception)
    }

    println(divideBy(1, 1))
    println(divideBy(1, 0))

    divideBy2(1, 0) match {
      case Left(s) => println("Answer: " + s)
      case Right(i) => println("Answer: " + i)
    }
  }


}
