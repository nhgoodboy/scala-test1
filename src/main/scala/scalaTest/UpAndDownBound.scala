package scalaTest

class Animal {}
class Bird extends Animal {}
class Consumer[-S,+T]() {
//  def m1[U >: T](u: U): T = {new T} //协变，下界
//  def m2[U <: S](s: S): U = {new U} //逆变，上界
}
//object UpAndDownBound extends App {
//  val c:Consumer[Animal,Bird] = new Consumer[Animal,Bird]()
//  val c2:Consumer[Bird,Animal] = c
//  c2.m1(new Animal)
//  c2.m2(new Bird)
//}

//class List[+T](val head: T, val tail: List[T]) {
//  def prepend[U >: T](newHead: U): List[U] = new List(newHead, this)
//  override def toString: String = "" + head
//}

//object UpAndDownBound {
//  def main(args: Array[String]): Unit = {
//    val list: List[Any] = new List[String]("摇摆少年梦", null)
//    println(list.prepend())
//  }
//}