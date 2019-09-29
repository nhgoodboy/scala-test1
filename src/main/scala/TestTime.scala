import java.util.{Calendar, Date}

/**
  * @description TODO
  * @author Yejiezhong
  * @date 2019/9/20 15:05
  **/
object TestTime {

  def main(args: Array[String]): Unit = {
    val a = System.currentTimeMillis() / 1000
//    Thread.sleep(5000)
    val b =  (System.currentTimeMillis / 1000 - a).toInt
//    println(b)
//    println(System.currentTimeMillis())


    val c = Calendar.getInstance()
    c.set(Calendar.YEAR, 2019)
    c.set(Calendar.MONTH, 7)
    c.set(Calendar.DAY_OF_MONTH, 23)
    c.set(Calendar.HOUR_OF_DAY, 11)
    c.set(Calendar.MINUTE, 33)
    c.set(Calendar.SECOND, 34)
    val d = c.getTimeInMillis
    println(d)
    println((d / 1000 - 1566531243).toInt)

    val e = 1566531243000L
    val f = new Date(e)
    println(f)

    println(new Date(d))
  }
}
