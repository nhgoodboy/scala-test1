package scalaTest

/**
 * Created by 80635 on 2019/3/15.
 */
object OptionTest {

    def main(args: Array[String]) {
        case class Player(val id: String, val name: String)

        val playerMap = Map("1" -> Player("1", "a"), "2" -> Player("2", "b"))

        def getPlayer(id: String): Option[Player] = playerMap.get(id)

        def contact2PlayerName(id1: String, id2: String): String = {
            (getPlayer(id1), getPlayer(id2)) match {
                case (Some(p1), Some(p2)) => p1.name + p2.name
                case (Some(p1), None) => p1.name + "<p2 not found>"
                case (None, Some(p2)) => "<p1 not found>" + p2.name
                case _ => "other condition"
            }
        }

        println(contact2PlayerName("1", "2"))
        println(contact2PlayerName("1", "3"))
        println(contact2PlayerName("4", "3"))

        val a = List(1, 2, 3, 4)
        val b = a.collect {
            case i if (i % 2 == 0) => i * 100
        }
        println(b)

        val aa = List("a", "ab", "abc")
        //        val bb : List[Char] = a.flatMap()
        println(aa)

        case class Ta(val id: String, val name: String)
        val ta1: List[Ta] = List(Ta("1", "a"), Ta("1", "a"), Ta("1", "fuck"))
        val ta2: Option[Ta] = ta1.find(p => p.name == "fuck")
        val ta3: Boolean = ta1.forall(p => p.name.contains("a"))
        println(ta3)

        val e = List(1,2,3,4,5)
        val f = e.foldLeft(10)((v, total) => total + v)
        val i = e.foldRight(11)((item, sum) => sum + item)
        println("i " + i)
        println("fold " + f)
        println("sum " + e.sum)

        val g = e.zip(List(100, 300, 500))
        val h = e.slice(3,8)
        println(h)


    }
}

