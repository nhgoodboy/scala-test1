object Test5 extends App{
  val products = List(new Test11, new Test12, new Test13)
  val test: Product = products.head

  def bb1(product: Test11): Unit = {
    println("bb1")
  }

  def bb1(product: Test12): Unit = {
    println("bb1")
  }

  def bb1(product: Test13): Unit = {
    println("bb1")
  }

  var map1 = Map.empty[Int,(Long,Int)]
  map1 += 1 -> (1,2)
  map1 += 2 -> (2,3)
  println(map1.map(p => (p._1, p._2._1, p._2._2)))

}

abstract class Product {
  def sell()
}

class Test11 extends Product{
  override def sell(): Unit = {
    println("Test11")
  }
}

class Test12 extends Product{
  override def sell(): Unit = {
    println("Test12")
  }
}

class Test13 extends Product{
  override def sell(): Unit = {
    println("Test13")
  }
}