package scalaTest

/**
 * Created by 80635 on 2019/3/15.
 */
class Test {
    val b = 10
    val a = 1
    val c = 2
  val ee = "ee"
}

class Test1 extends Test {
    //    override val a = 2
    override val b = 3

}

case class MyTestClassWithParam(val a: Int, var b: Int) {

}

class MyTestClassWithConstruct {
    var a: Int = 0
    var b: Int = 0
}

object MyTestClassWithConstruct {
    def apply(initA: Int, initB: Int): MyTestClassWithConstruct = {
        val nc = new MyTestClassWithConstruct
        nc.a = initA
        nc.b = initB
        nc
    }
}

object Test extends Test {
    def main(args: Array[String]) {
//        val enum: EnumerationTest.EnumrationTest = EnumerationTest.Black
//        println(enum.getClass.getName)
        val cc = new Test1()
        println(cc.a)
        val dd = new Test()
        println(dd.a)
        println(Test.b)
        println(fun1(fe))
        println(fun9(2))
        println(fun9(2)(4))
        println(fun13(1))
        //        val c2 = MyTestClassWithParam(100, 200)
        println(MyTestClassWithParam(100, 200).a + MyTestClassWithParam(300, 400).b)

        var bn = 2
//        bn = null
//        println(bn.isInstanceOf[Int])
    }

    def fe(a: Int): Boolean = {
        if (a == 5)
            true
        else
            false
    }

    def fun1(f: Int => Boolean) = {
        f(5) && true
    }

    def fun9(a: Int): Int => Int = {
        def halfFun(b: Int) = a + b
        halfFun
    }

    def fun13(a: Int*): Unit = {
        println(a)
    }
}
