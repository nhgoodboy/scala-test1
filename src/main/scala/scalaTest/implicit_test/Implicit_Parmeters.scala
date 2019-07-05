package scalaTest.implicit_test

object Context_Implicits {
  implicit val default: String = "Java"
}

object Param {
  def print(context: String)(implicit language: String): Unit = {
    println(language + ":" + context)
  }
}

object Implicit_Parmeters {

  def main(args: Array[String]): Unit = {
    Param.print("Spark")("Scala")
    import Context_Implicits._
    Param.print("Hadoop")
  }
}
