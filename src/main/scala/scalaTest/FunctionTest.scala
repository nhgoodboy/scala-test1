package scalaTest

object FunctionTest extends App {

  val succ = (x: Int) => x + 1

  val anonfun1 = new Function1[Int, Int] {

    def apply(x: Int): Int = x + 1

  }
  println(assert(succ(0) == anonfun1(0)))

  println("finish")

}
