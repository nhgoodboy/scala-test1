package scalaTest.pattern.flyweight_pattern

abstract class Flyweight(final val extrinsic: String) {

  var intrinsic: String = _

  def operate(extrinsic: Int)

  def getIntrinsic: String = {
    intrinsic
  }

  def setIntrinsic(intrinsic: String): Unit = {
    this.intrinsic = intrinsic
  }

}
