package countdownlatchtest

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/9/7 17:29
  **/
object HelloServiceTest {

  def main(args: Array[String]): Unit = {
    val helloService = new HelloServiceImpl
    val currentTimeMills = System.currentTimeMillis()
    val countDownLatchUtil = new CountDownLatchUtil(1000)
    countDownLatchUtil.latch(() =>{
      helloService.sayHello(currentTimeMills)
    })
  }
}
