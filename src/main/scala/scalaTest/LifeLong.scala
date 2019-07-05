package scalaTest

/**
 * Created by 80635 on 2019/3/15.
 */
trait LifeLong {
    def addLife(second: Int = 1)
}

trait HighLevel {
    val talk_with_journalist = true
}

trait MiddleLevel {
    val talk_with_journalist1 = false
}

class Elder extends LifeLong with HighLevel with MiddleLevel {
    override def addLife(second: Int): Unit = {

    }
}



object Test2 {
    def main(args: Array[String]) {
        val a = new Elder
        println(a.talk_with_journalist)
        val tp3 = Tuple3(100, 200, "asd")
        println(tp3)
        var map = Map(1 -> 2, 2 -> 3)
        println(map(1))
        map += 3 -> 4
        println(map(3))

        val fora = for (x <- 1 to 10) yield x * 10
        println(fora(0))

        val mapb = (1 to 4).map(x => x * 10)
        println(mapb)

        val l1 = List(1, 2, 3, 4)

        for {
            i1 <- l1 if (i1 > 2)
        } {
            println(i1)
        }

        println(matchTest(2))
    }

    def matchTest(x: Int): String = {
        x match {
            case 1 => "one"
            case 2 => "two"
            case 3 => "three"
            case _ => "many"
        }
    }
}
