package countdownlatchtest

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/9/7 17:24
  **/
class HelloServiceImpl extends HelloService{

  override def sayHello(timeMillis: Long): Unit = {
    val time = System.currentTimeMillis() - timeMillis
    if (time > 3000) {
      println(s"time: $time")
    }
    try {
      Thread.sleep(1000)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
