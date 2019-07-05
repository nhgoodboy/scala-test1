package scalaTest.pattern.state_pattern

// 状态模式适用于某一个对象的行为取决于该对象的状态，并且该对象的状态会在运行时转换，又或者有很多的if else判断，而这些判断只是因为状态不同而不断的切换行为。
object NewClient {

  def main(args: Array[String]): Unit = {
    val hero = new NewHero
    hero.startRun()
    hero.setState(NewHero.SPEED_UP)
    Thread.sleep(5000)
    hero.setState(NewHero.SPEED_DOWN)
    Thread.sleep(5000)
    hero.setState(NewHero.SWIM)
    Thread.sleep(5000)
    hero.stopRun()

  }
}
