package scalaTest.pattern.state_pattern

class SpeedUpState extends TRunState {

  override def run(hero: NewHero): Unit = {
    println("------加速跑动------")
    try {
      Thread.sleep(4000)
    } catch {
      case _ : InterruptedException =>
    }
    hero.setState(NewHero.COMMON)
    println("------加速状态结束，变为正常状态------")
  }
}
