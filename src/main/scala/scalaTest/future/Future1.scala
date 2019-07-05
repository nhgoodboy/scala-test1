package scalaTest.future

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * @Author Yejiezhong
  * @Date 2019/4/26 12:21
  * @Version 1.0
  **/
object Future1 extends App {

  implicit val baseTime: Long = System.currentTimeMillis

  val f = Future {
    sleep(2000)
    1 + 1
  }

  // 3 - this is blocking (blocking is bad)
  val result = Await.result(f, 3 seconds)
  println(result)
  sleep(1000)

  def sleep(time: Long): Unit = {
    Thread.sleep(time)
  }

  for (r1 <- 1 to 10) {
    println(r1)
  }
}
