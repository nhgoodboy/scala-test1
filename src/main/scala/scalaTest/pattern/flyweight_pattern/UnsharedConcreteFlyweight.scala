package scalaTest.pattern.flyweight_pattern

class UnsharedConcreteFlyweight(var subExtrinsic: String) extends Flyweight(extrinsic = subExtrinsic) {

  override def operate(extrinsic: Int): Unit = {
    println("不共享的具体Flyweight: " + extrinsic)
  }
}
