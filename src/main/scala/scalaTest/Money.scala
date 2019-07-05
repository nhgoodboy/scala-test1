package scalaTest

/**
 * Created by 80635 on 2019/3/16.
 */
class Money(val value: Double, val country: String) {
}

object FunctionClass {
    def function1 = {
        val a = 1 + 2 + 3
        a
    }
}

object Money {
    final val EMPTY: Money = empty

    def empty = new Money(11.0, "asd")

    def apply(value: Double, country: String) = new Money(value, country)

    def unapply(money: Money): Option[(Double, String)] = {
        if (money == null) {
            None
        } else {
            Some(money.value, money.country)
        }
    }

    def main(args: Array[String]) {
        val money = Money(10.1, "RMB")
        money match {
            case Money(num, str) => println(str, +num)
            case _ => println("Not RMB!")
        }

        for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(s"${10 * i + j} ")
        println(FunctionClass.function1)
    }
}
