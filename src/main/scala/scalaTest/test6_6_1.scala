package scalaTest

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/6/6 19:50
  **/
object test6_6_1 {
  def main(args: Array[String]): Unit = {
    println(test6_6.c)

    val list1 = List(1,2,3,4,5)
    val list2 = List(3,4,5,6,7)
    println(list1.diff(list2))

  }
}
