package scalaTest

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/9/26 19:48
  **/
object TestConcurrent {

  def main(args: Array[String]): Unit = {
    val t1 = new Thread(new DeadLockClass(true))
    val t2 = new Thread(new DeadLockClass(false))
    t1.start()
    t2.start()
  }
}

class DeadLockClass(flag: Boolean) extends Runnable {


  override def run(): Unit = {
    if (flag) {
      while (true) {
        Suo.o1.synchronized {
          println("o1" + Thread.currentThread().getName)
          Suo.o2.synchronized {
            println("02" + Thread.currentThread().getName)
          }
        }
      }
    } else {
      while (true) {
        Suo.o2.synchronized {
          println("o2" + Thread.currentThread().getName)
          Suo.o1.synchronized {
            println("o1" + Thread.currentThread().getName)
          }
        }
      }
    }
  }
}

object Suo {
  final val o1: Object = new Object()
  final val o2: Object = new Object()
}
