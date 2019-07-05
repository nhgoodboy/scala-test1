package scalaTest

import scala.beans.BeanProperty

/**
 * Created by yjz on 2019/3/16.
 */
class GetTest {
    private[this] val a = 0
    @BeanProperty var name: String = _


//    outer =>
//    class Member(val name: String) {
//        def
//    }
}

object GetTest1 extends App{
    println("hello")
}
