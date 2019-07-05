package thread

import java.util.concurrent.TimeUnit

/**
  * @Description TODO
  * @Author Yejiezhong
  * @Date 2019/4/30 16:37
  * @Version 1.0
  **/
class MyRunnable extends Runnable {
  override def run(): Unit = {
    val currentThread = Thread.currentThread();
    println(currentThread.getName + "-----come inoo" + 123)
    try {
      TimeUnit.SECONDS.sleep(5)
    } catch {
      case e: InterruptedException => e.printStackTrace()
      case _ =>
    } finally {
      println(currentThread.getName + "-----leave")
    }
  }
}

object MyRunnable {
  def main(args: Array[String]): Unit = {
    val myRunnable = new MyRunnable
    val thread1 = new Thread(myRunnable, "thread1")
    val thread2 = new Thread(myRunnable, "thread2")
    val thread3 = new Thread(myRunnable, "thread3")

    thread1.start()
    thread2.start()
    thread3.start()
  }
}
