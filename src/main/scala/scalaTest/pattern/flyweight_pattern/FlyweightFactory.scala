package scalaTest.pattern.flyweight_pattern

object FlyweightFactory {

  private var pool = Map.empty[String, Flyweight]

  def getFlyweight(extrinsic: String): Flyweight = {
    var flyweight: Flyweight = null

    if (pool.contains(extrinsic)) {
      flyweight = pool.getOrElse(extrinsic, null)
      print("已有 " + extrinsic + " 并从池中取出---->")
    } else {
      flyweight = new ConcreteFlyweight(extrinsic)
      pool += extrinsic -> flyweight
      print("创建 " + extrinsic + " 并从池中取出---->")
    }
    flyweight
  }
}
