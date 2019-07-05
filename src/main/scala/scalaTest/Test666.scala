package scalaTest

sealed abstract class Haha {}

case class Haha1(a: String) extends Haha

case class Haha2(a: String) extends Haha

case class Haha3(a: String) extends Haha

object Test666 extends App {

  //  val amt = new Haha2("1")
  //  amt match {
  //    case Haha1(a: String) => println("1")
  //    case Haha2(a: String) => println("2")
  ////    case Haha3() => println("3")
  //  }
  private val hello = "Hello World!"
  println(hello)

  {
    var list1 = List(1, 2, 3)
    var list2 = List(4, 5, 6)
    list1 ::= 9
    println(list1)

    val arr = Array(1, 2, 3, 5, 6, 7)
    print(arr(2))

    val acc = "a"
    val a = "s"
    var map = Map(acc -> (acc + "11"), "b" -> "b")
    println(map(acc))

    val yh: Any = Map.empty[Int, String]
    println(yh.getClass)
  }

  println(packA)
  println(packB)
  println(packC)
  packC = 99
  println(packC)
  Test5.printlnA()
  println(scalaTest.packA)
  val arr = Array(4,3,5,6,8)
  println(arr.head)
  println(arr.last)
}


