package scalaTest.pattern.flyweight_pattern

object Client {

  def main(args: Array[String]): Unit = {
    var extrinsic = 22
    val flyweightX = FlyweightFactory.getFlyweight("X")
    flyweightX.operate{extrinsic += 1; extrinsic}
    val flyweightY = FlyweightFactory.getFlyweight("Y")
    flyweightY.operate{extrinsic += 1; extrinsic}
    val flyweightZ = FlyweightFactory.getFlyweight("Z")
    flyweightZ.operate{extrinsic += 1; extrinsic}

    val flyweightReX = FlyweightFactory.getFlyweight("X")
    flyweightReX.operate{extrinsic += 1; extrinsic}

    val unsharedFlyweight = new UnsharedConcreteFlyweight("X")
    unsharedFlyweight.operate{extrinsic += 1; extrinsic}
  }
}
