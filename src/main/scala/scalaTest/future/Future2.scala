package scalaTest.future

import scala.concurrent.Future
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * @Description TODO
  * @Author Yejiezhong
  * @Date 2019/4/26 14:16
  * @Version 1.0
  **/
object Future2 extends App {

  println("starting calculation ...")

  val f = Future {
    sleep(Random.nextInt(500))
    42
  }

  println("before onComplate")
  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(exception) => exception.printStackTrace()
  }

  def sleep(time: Long): Unit = {
    Thread.sleep(time)
  }

  println("A...")
  sleep(100)
  println("B...")
  sleep(100)
  println("C...")
  sleep(100)
  println("D...")
  sleep(100)
  println("E...")
  sleep(100)
  println("F...")
  sleep(2000)

}
