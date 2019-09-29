package countdownlatchtest

import java.util.concurrent.{CountDownLatch, ExecutorService, Executors}

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/9/7 17:04
  **/
class CountDownLatchUtil(var poolSize: Int) {

  private val start: CountDownLatch = new CountDownLatch(1)
  private val end: CountDownLatch = new CountDownLatch(poolSize)

  def latch(functionalInterface: MyFunctionalInterface): Unit = {
    val executorService: ExecutorService = Executors.newFixedThreadPool(poolSize)
    for (_ <- 1 to poolSize) {
      val run = new Runnable {
        override def run(): Unit = {
          try {
            start.await()
            functionalInterface.run()
          } catch {
            case e: InterruptedException => e.printStackTrace()
          } finally {
            end.countDown()
          }
        }
      }
      executorService.submit(run)
    }
    start.countDown()
    end.await()
    executorService.shutdown()
  }

  @FunctionalInterface
  trait MyFunctionalInterface {
    def run()
  }
}
