package scalaTest.future

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/4/26 14:26
  * @version 1.0
  **/
object Future4 extends App {

  implicit val baseTime = System.currentTimeMillis

  println(baseTime)
  Thread.sleep(1000
  )
  println(baseTime)
}
