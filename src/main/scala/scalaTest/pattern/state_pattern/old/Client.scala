package scalaTest.pattern.state_pattern.old

object Client {

  def main(args: Array[String]): Unit = {
    val hero = new Hero
    hero.startRun()
    hero.setState(Hero.SPEED_UP)
    Thread.sleep(5000)
    hero.setState(Hero.SPEED_DOWN)
    Thread.sleep(5000)
    hero.setState(Hero.SWIM)
    Thread.sleep(5000)
    hero.stopRun()
  }
}
