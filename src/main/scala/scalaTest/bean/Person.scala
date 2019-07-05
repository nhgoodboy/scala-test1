package scalaTest.bean

trait Trait1 {
  val name: String = "a"
}

trait Trait2 {
  val name: String = "b"
}

class Person extends Trait1 with Trait2 {

//  @BeanProperty var name: String = _
  var sex: String = _
  override val name: String = "asd"
}

object Person {

  def main(args: Array[String]): Unit = {
    val obj = new Person
    println(obj.name)
//    println(obj.)
    ::
  }
}
