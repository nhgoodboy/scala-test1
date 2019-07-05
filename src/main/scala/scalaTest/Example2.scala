package scalaTest

import java.util

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * 快速入门example 集合类
  * Created by Administrator on 2017/11/6/006.
  */
object Example2 {
  def main(args: Array[String]) {
    //可变不可变, 官方推荐尽量使用不可变, 据说可以提高垃圾回收性能
    val a = Map.empty[Int, Int] //因为a是val了不可赋值, 默认的Map 是不可变的,所以这个a永远都是 一个空Map了
    //  a += 1 -> 5 会报错, a不可赋值
    var b = Map.empty[Int, Int] //因为b是var可重新赋值, 默认的Map 是不可变的,所以每次更新并赋值要产生一个新的map
    val bRef1 = b
    b += 1 -> 5
    b += 3 -> 6
    println(b(3))
    val bRef2 = b
    println(bRef1 eq bRef2) //false , 不是同一个地址的对象

    val c = mutable.Map.empty[Int, Int] // c是val 不可赋值,但是 mutable.Map是可变的,所以改变的是c自己内部
    val cRef1 = c
    c += 1 -> 5
    val cRef2 = c
    println(cRef1 eq cRef2) //true , 同一个地址的对象


    //可变转成不可变 用 to结构名 函数
    val d = mutable.Map(1 -> 3)
    val d1 = d.toMap
    val e = mutable.Set(1, 2)
    val e1 = e.toSet
    val f = mutable.ListBuffer(1, 2, 3, 4)
    val f1 = f.toList

    //不可变转为可变, 创建一个可变的, 把不可变的全部元素加进去
    val g = Map(1 -> 3)
    val g1 = mutable.Map.empty ++ g
    val h = Set(1, 2)
    val h1 = mutable.Set.empty ++ h
    val i = List(1, 2, 3, 4)
    val i1 = mutable.ListBuffer.empty ++ i

    //由java跟scala集合互转, 要先import scala.collection.JavaConverters._
    val javaMap = new util.HashMap[Integer, Integer]()
    javaMap.put(1, 5)
    val scalaMap = javaMap.asScala
    val javaMap2 = scalaMap.asJava


    //常用集合操作
    // 例如有一个 TmpPlayer的 List
    case class TmpPlayer(age: Int, name: String)
    val playerList = List(
      TmpPlayer(10, "tom"), TmpPlayer(20, "peter"), TmpPlayer(30, "dave"), TmpPlayer(22, "kitty")
    )

    //过滤出某些符合条件的东西, 条件判断函数要返回一个boolean, 把整函数传进filter函数, 比如过滤出名字带t字母的
    def conditionFun(tmpPlayer: TmpPlayer) = tmpPlayer.name.contains("t")

    val nameWithT = playerList.filter(conditionFun)
    //可以不用定义判断函数, 直接把函数匿名写在里面就行
    val nameWithTv2 = playerList.filter(tmpPlayer => tmpPlayer.name.contains("t"))
    //再进一步简化, _即是map传入的 tmpPlayer, 但只有在 _ 只能被引用一次的情况下使用
    val nameWithTv3 = playerList.filter(_.name.contains("t"))

    //找出里面年龄最大,最小的对象
    //给maxBy传入一个用于选取TmpPlayer指定哪个最大最小的属性
    val maxAgePlayer = playerList.maxBy(_.age) // dave
    val minAgePlayer = playerList.minBy(tmpPlayer => tmpPlayer.age) // tom

    //把所有List里的玩家名字映射成一个新的列表
    val nameList = playerList.map(tmpPlayer => tmpPlayer.name).head
    println(nameList)
    val nameList2 = playerList.map(_.name)
    println(nameList2)
    //遍历List
    playerList.foreach(tmpPlayer => {
      //这里对每个tmpPlayer 做些什么
      println(tmpPlayer.age)
    })

    //遍历 Map
    val tmpMap = Map(1 -> 2, 2 -> 3, 3 -> 4)
    tmpMap.foreach {
      case (key, value) =>
      //对key或value做些什么
    }
    //也可以
    tmpMap.foreach(tp => {
      //key就是 tp._1, value就是 tp._2 只不过这样可读性有点差
    })

    //也可以
    tmpMap.foreach {
      case (key, value) =>
        //这里是一种语法糖, scala把 每个 key,value 自动匹配成一个个元组, key,value这个名字可以自己定
    }

    //过滤map, 就把上面的foreach换成filter就行, 里面函数换成过滤条件的boolean函数就行
    tmpMap.filter {
      case (key, value) => key + value >= 5
    } //过滤出一个新的map 符合 key和value相加>=5

    //直接返回map的所有key或所有value
    tmpMap.keys
    tmpMap.values


    //List操作
    var tmpLs = List(1, 2, 3)
    //头添加
    tmpLs ::= 0 // 0,1,2,3
    println(tmpLs)
    //尾添加
    tmpLs = tmpLs :+ 4
    println(tmpLs) // 0,1,2,3,4
    //删除, 用filter

    //其他数据结构操作文档
    //http://www.scala-lang.org/api/current/index.html
  }

}