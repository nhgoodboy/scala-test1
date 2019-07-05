package scalaTest.pattern.prototype_pattern

class Resume(private var name: String) extends Cloneable {

  private var birthday: String = _
  private var sex: String = _

  def setPersonInfo(birthday: String, sex: String): Unit = {
    this.birthday = birthday
    this.sex = sex
  }

  override def clone(): AnyRef = {
    var resume: Resume = null
    try {
      resume = super.clone().asInstanceOf[Resume]
    } catch {
      case e : CloneNotSupportedException => e.printStackTrace()
    }
    resume
  }

  def display(): Unit = {
    println("name: " + name)
    println("birthday: " + birthday)
    println("sex: " + sex)
  }
}
