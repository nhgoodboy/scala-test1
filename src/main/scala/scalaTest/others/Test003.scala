package scalaTest.others

object Test003 {

  def main(args: Array[String]): Unit = {
    val a = new Test001("1")
    val b = new Test002(2)
    println(b)
    a match {
      case s: Test002 => println("haha")
      case _ =>
    }
  }
}
