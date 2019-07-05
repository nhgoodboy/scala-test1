package scalaTest

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/6/29 14:33
  **/
object Test6_29 {
  def unapply(arg: Test6_29): Option[Int] = {
    if (arg.a == 2) {
      Some(arg.a)
    } else {
      None
    }
  }

  def main(args: Array[String]): Unit = {
    val test = new Test6_29
    test match {
      case Test6_29(2) => println("ok")
      case _ => println("fuck")
    }

    val f: PartialFunction[String, Int] = {
      case "a" => 1
      case "b" => 2
      case _ => 3
    }
    println(f("a"))
    println(f("c"))
  }
}

class Test6_29 {
  val a = 1
  val b = 2
}
