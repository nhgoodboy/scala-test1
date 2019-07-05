import scala.reflect.ClassTag

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/5/30 16:56
  **/
class ScalaArrayDemo[T] {

  private val secret = 2

  def makeTArray[T: ClassTag](): Array[T] = new Array[T](10)

}

object ScalaArrayDemo {

//  def double(foo: )

  def main(args: Array[String]): Unit = {
    val a = List[Int](20)
    val b = new ScalaArrayDemo[Int].makeTArray()
    val c = Array(20, 30, 40, "20")
    println(a.isInstanceOf[List[Int]])
    println(b.isInstanceOf[Array[Int]])
    println(c.isInstanceOf[Array[Int]])
  }
}
