package scalaTest.implicit_test

object Implicit_Conversion_Parameters {

  def main(args: Array[String]): Unit = {
    def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T]): T = {
      if (ordered(a) > b) a else b
    }
    println(bigger(4,3))
    println(bigger("Spark", "Hadoop"))
  }
}
