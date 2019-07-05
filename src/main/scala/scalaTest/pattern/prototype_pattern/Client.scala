package scalaTest.pattern.prototype_pattern

object Client {

  def main(args: Array[String]): Unit = {
    val resume = new Resume("lili")
    resume.setPersonInfo("1990-01-02", "man")

    val resume1: Resume = resume.clone().asInstanceOf[Resume]
    println("aaaaa")
    resume.display()
    println("bbbbb")
    resume1.display()
    println(resume.getClass)

  }
}
