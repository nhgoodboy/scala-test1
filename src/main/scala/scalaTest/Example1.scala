package scalaTest

/**
 * 快速入门example
 * Created by Administrator on 2017/11/6/006.
 */
object Example1 {
    def main(args: Array[String]) {

        //变量
        // var可变量, val不可变量,尽量用val,能不用var就不用var
        // 定义变量  变量名 : 变量类型, 如果初始赋值了,也可以不填类型由值推倒出来.
        var i = 1
        val j = 2
        i = 2 //可以
        //j = 3 //编译报错

        //函数调用, 有时候可以直接把点替换成空格调用比如
        val x = 1
        val y = 5
        val z = x + y
        val z1 = x.+(y) // x + y 其实真正调用的是这样的
        println("1" equals "1") // 跟下面的是一样的
        println("1".equals("1")) //


        //定义函数
        // def 函数名(参数: 类型, 参数2 : 类型) : 返回值类型 = {
        //   函数体
        // }
        // 返回值类型可以不写由最后返回的内容推导, 函数体如果只有一行可以不用 {} , 下面几个都一样的
        def fun1: Boolean = true & false

        def fun2: Boolean = {
            true & false
        }

        def fun3 = true & false

        //没有返回值的函数 返回值可以是Unit也可以不写
        def fun33 = {

        }
        def fun333: Unit = {

        }

        //函数里面也可以定义函数
        def fun4 = {
            def fun5(aaa: Int) = 1 + aaa

            println(fun5(5))
        }

        //函数返回, 不用写return 除非程序跑一半要强制返回. 一般就把要返回的写在函数最后, 如果有if 那么在else里最后也要写上返回
        def fun6(a: Boolean): Int = {
            if (a) {
                //do something
                1
            } else {
                //do something
                val ohNo = false
                if (ohNo) return 5
                2
            }
        }

        //函数传递, scala可以把函数当成一个可传递的东西传给其他函数,

        //fun7 接受的参数f 就是一个以Int作为参数以Boolean作为返回值的函数
        def fun7(f: Int => Boolean) = {
            f(5) && true
        }

        def fun8(a: Int): Boolean = if (a == 0) false else true
        //把fun8作为参数传进fun7里
        println(fun7(fun8))


        //柯里化 函数也可以返回个半成品函数供外面调用, fun9这个函数,接受一个int型参数a, 返回一个 以int型为参数,以int型为返回 的函数
        def fun9(a: Int): Int => Int = {
            def halfFun(b: Int) = a + b

            halfFun
        }

        println(fun9(2)(4)) //fun9(2)先返回一个  2 + b 函数, 再对2+b函数调用把b值传进来, 所以结果是 6


        // 创建一个类
        class MyTestClass {
        }
        val c1 = new MyTestClass

        //创建一个带属性的类, 同时把这些属性作为构造函数
        class MyTestClassWithParam(val a: Int, var b: Int) {
        }
        val c2 = new MyTestClassWithParam(100, 200)
        println(c2.a)

        // 创建一个单例类 类似 static 类. 可以跟同名类共存.
//        object MyTestClassObject {
//            def hello = println("hello")
//        }
        class MyTestClassObject {
            def hello = println("hello")
        }
        new MyTestClassObject().hello


        //创建一个样例类, 可以不用new就可以创建对象
        case class MyTestCaseClass(val a: Int, val b: Int)
        val c3 = MyTestCaseClass(50, 100)
        println(c3.b) //100


        //自定义类的构造函数, 在这个类对应的单例类里加上apply方法
        class MyTestClassWithConstruct {
            var a: Int = 0
            var b: Int = 0
        }
        object MyTestClassWithConstruct {
            def apply(initA: Int, initB: Int): MyTestClassWithConstruct = {
                val nc = new MyTestClassWithConstruct()
                nc.a = initA
                nc.b = initB
                nc
            }
        }
        val c4 = MyTestClassWithConstruct(200, 300) //这里就直接调用到 object MyTestClassWithConstruct里的apply了


        //元组, scala 里有一种数据结构叫 Tuple2,其实就是可以存放2个东西的结构. 他添加了语法糖箭头 -> 来简化他的操作
        val tp1 = Tuple2(100, 200)
        val tp2 = 100 -> 200
        val tp3 = (100, 200)
        println(tp1 == tp2) //true
        println(tp2 == tp3) //true
        println(tp1 == tp3) //true
        println(tp1._1) // 100
        println(tp1._2) // 200
        val tp4 = Tuple3(100, 200, 300)
        val tp5 = 100 -> 200 -> 300 //这样写其实是 Tuple2(Tuple2(100,200),300)

        //scala的Map数据结构就经常使用这种元组
        var m = Map(1 -> 2)
        m += 2 -> 3
        println(m) // Map(1 -> 2, 2 -> 3)


        //比较
        val str1 = "233"
        val str2 = new String("233")
        println(str1 == str2) // true,  跟java不同如果比较对象不是空, scala的==就是调用的equals
        println(str1 eq str2) // false 要比较地址用 eq
        println(str1.equals(str2)) // true ,跟java一样

        //break, continue   scala里没有这2种操作. 可以通过其他代码方式避免不使用这2种操作.
        //实在很想做这种操作只能用 try catch 和抛异常来实现. 目前有现成封装但很少用


    }

}