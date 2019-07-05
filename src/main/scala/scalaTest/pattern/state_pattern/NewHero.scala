package scalaTest.pattern.state_pattern

object NewHero {

  final val COMMON: TRunState = new CommonState
  final val SPEED_UP: TRunState = new SpeedUpState
  final val SPEED_DOWN: TRunState = new SpeedDownState
  final val SWIM: TRunState = new SwimState
}

class NewHero {

  private var state = NewHero.COMMON
  private var runThread: Thread = _

  def setState(state: TRunState): Unit = {
    this.state = state
  }

  def isRunning: Boolean = {
    runThread != null && !runThread.isInterrupted
  }

  def stopRun(): Unit = {
    if (isRunning) {
      runThread.interrupt()
    }
    println("------停止跑动------")
  }

  def startRun(): Unit = {
    if (isRunning) {
      return
    }
    val hero: NewHero = this
    runThread = new Thread(() => {
      while (!runThread.isInterrupted) {
        state.run(hero)
      }
    })
    println("------开始跑动------")
    runThread.start()
  }
}
