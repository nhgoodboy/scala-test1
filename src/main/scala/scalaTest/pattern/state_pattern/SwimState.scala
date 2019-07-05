package scalaTest.pattern.state_pattern

class SwimState extends TRunState {

  override def run(hero: NewHero): Unit = {
    println("------不能跑动------")
    try {
      Thread.sleep(2000)
    } catch {
      case _ : InterruptedException =>
    }
    hero.setState(NewHero.COMMON)
    println("------眩晕状态结束，变为正常状态------")
  }
}
