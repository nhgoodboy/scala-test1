package scalaTest.future

import java.util.{Timer, TimerTask}

import scala.concurrent.{Future, Promise}

object TimedEvent {

  val timer = new Timer

  def delayedSuccess[T](secs: Int, value: T): Future[T] = {
    val result = Promise[T]
    timer.schedule(new TimerTask {
      override def run(): Unit = {
        result.success(value)
      }
    }, secs * 1000)
    result.future
  }

  def delayedFailure(secs: Int, msg: String): Future[Int] = {
    val result = Promise[Int]
    timer.schedule(new TimerTask {
      override def run(): Unit = {
        result.failure(new IllegalArgumentException(msg))
      }
    }, secs * 1000)
    result.future
  }

  def main(args: Array[String]): Unit = {
    val f = delayedSuccess(10, "asd")
    //    implicit val ec: ExecutionContext =  ...
    //    val inverseFuture : Future[Matrix] = Future {
    //      fatMatrix.inverse()
    //    } // ec is implicitly passed
  }
}
