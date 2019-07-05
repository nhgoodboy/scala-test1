package scalaTest.pattern.flyweight_pattern

class ConcreteFlyweight(var subExtrinsic: String) extends Flyweight(subExtrinsic) {

  override def operate(extrinsic: Int): Unit = {
    println("具体Flyweight: " + extrinsic)
  }
}
