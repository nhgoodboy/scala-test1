package scalaTest

class Test5(val a: String, val b: String) {

  private val c = "asd"

  def getA(): String = {
    a
  }

}

//class Test6 {
//  private val d = "d"
//}

object Test5 {

  val e = "e"

  def main(args: Array[String]): Unit = {
    val obj = new Test5("a", "b")
    //    val obj6 = new Test6
    println(obj.a)
    println(Constants.DEFAULT_FACE_ID)
    println(IConstants.DEFAULT_RIDE_ID)
    println(Constants.DEFAULT_HAIR_ID)
  }

  def printlnA(): Unit = {
    println(packC)
  }
}
