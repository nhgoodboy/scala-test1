package scalaTest

import java.util.concurrent.Executor

import scala.util.Random

/**
 * 快速入门example 杂碎
 * Created by Administrator on 2017/11/6/006.
 */
object Example3 {
  def main(args: Array[String]) {

    //匹配模式
    //scala 有很多种匹配模式
    val x: Int = Random.nextInt(10)
    val matchResult = x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case 3 | 4 => "three or four"
      case _ => "many" //注意, match 如果全部都没匹配到会报错的 , 所以要加上 _=> 表示匹配上面的case全部都都没匹配到的情况应该怎么做
    }
    println("x : " + x + " match Result:" + matchResult)

    //匹配模式还可以匹配某个类的子类
    //比如 Player extends Actor
    //     Monster extends Actor
    class Actor
    class Player extends Actor
    class Monster extends Actor

    val p1 = new Player
    val m1 = new Monster
    val r1 = p1 match {
      case p: Actor =>
        "p1 is a actor"
      case p: Player =>
        "p1 is a player "
    }
    //这里p1会匹配到 Actor, 其实这里 Actor 和Player 都会匹配到p1, 但是因为 匹配Actor的代码在上面, 所以会先匹配到Actor,之后就直接返回"p1 is a actor" 并且赋值给r1了
    //但如果代码换成下面的
    val r2 = p1 match {
      case p: Player =>
        "p1 is a player "
      case p: Actor =>
        "p1 is a actor"
    }
    //把匹配成 player和actor 的位置互换, 那么 Player先匹配成功, 然后直接就返回 "p1 is a player " 赋值给 r2了
    //所以匹配某个类是 哪个对象但有可能是判断父级对象的时候需要注意这种情况

    //假设一个ls里面有 123字符串, 123 Int, 123 Long, 123 Double, 123F 我要循环对每个元素,根据不同类型来操作
    val ls = List("123", 123, 123L, 123D, 123F, 234F)
    ls.foreach(value => {
      value match {
        case i: Int =>
        //是Int 时怎么处理
        case l: Long =>
        //是Long 时怎么处理
        case d: Double =>
        //是Double 时怎么处理
        case s: String =>
        //是String 时怎么处理
        case 123F =>
        //如果value的值是 123浮点型时怎么处理
        case _ =>
        //其他情况下怎么处理
      }
    })

    //匹配模式还可以有不用match 关键字的写法比如
    val tuple1 = ("11111", 22222)
    //我想要把 这个 元组的key和value匹配成我自己定义的变量
    val (keyOfTuple1: String, valueOfTuple1: Int) = tuple1
    println(keyOfTuple1) // "11111"
    println(valueOfTuple1) // 22222

    //其他匹配模式参考文档
    //https://docs.scala-lang.org/tour/pattern-matching.html


    //None 和 null
    //如果一个变量可能存在可能不存在, scala建议使用 Option[类型] 来存储. 你可以把Option当成是只有1个元素的特殊集合来看待
    val list = List(1, 2, 3, 4)
    //就比如find函数, 他不确定能否找得到符合条件的数字, 所以返回的是一个 Option[Int]
    val find: Option[Int] = list.find(_ > 5)
    find match {
      case None =>
      //由你决定找不到怎么办
      case Some(value) =>
      //由你决定找到想要的value值怎么办
    }

    //或是
    if (find.isEmpty) {
      val value = find.get
      //找到了 对value处理
    } else {
      //没找到, 应该怎么处理
    }


    case class A(val a: Int, val b: Int)
    val map1 = Map(1 -> A(111, 1111), 2 -> A(222, 2222), 3 -> A(333, 3333))
    val map2 = Map(4 -> A(444, 4444))


    //不要用 getOrElse(null) 因为一旦取不到对象就返回null很容易引发 NullPointerException
    println(map1.getOrElse(1, null).a + map1.getOrElse(4, null).a) //111 + 报 NullPointerException
    //而且这种情况很难判断出 到底是 map1.getOrElse(1, null).a 出的 NullPointerException 还是 map1.getOrElse(4, null).a 出的 NullPointerException

    //可以先用get, get 出来个 Option[A], 再做判断
    var finalResult = 0 //0默认值
    (map1.get(1), map2.get(4)) match {
      case (Some(value1), Some(value2)) =>
        //都找到了, 可以愉快的相加了
        finalResult = value1.a + value2.a
      case (None, Some(value2)) =>
      //第一个找不到, 第二个找到了怎么办的代码
      case (Some(value1), None) =>
      //第一个找到了, 第二个找不到怎么办的代码
      case _ =>
      //其他情况
    }



    //不要在一个线程池的运行函数里显示的使用 return  比如我们项目的线程池 (应该说scala强烈推荐不使用任何 return )
//    Executor.execute({
//      val a = 1
//      if(a == 1) return
//      else {
//        //do something
//      }
//    })
    //会报一个
    //Exception in thread "pool-1-thread-1" java.lang.Error: scala.runtime.NonLocalReturnControl$mcV$sp
    //的错误
    //改成这样
//    Executor.execute({
//      val a = 1
//      if(a != 1) {
//        //do something
//      }
//    })

  }

}