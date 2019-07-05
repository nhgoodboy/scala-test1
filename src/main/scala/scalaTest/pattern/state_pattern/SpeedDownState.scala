package scalaTest.pattern.state_pattern

class SpeedDownState extends TRunState {

  override def run(hero: NewHero): Unit = {
    println("------减速跑动------")
    try {
      Thread.sleep(4000)
    } catch {
      case _ : InterruptedException =>
    }
    hero.setState(NewHero.COMMON)
    println("------减速状态结束，变为正常状态------")
  }
}
