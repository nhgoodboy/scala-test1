package scalaTest.pattern.state_pattern.old

import scala.util.control.Breaks._

object Hero {
  final val COMMON = 1
  final val SPEED_UP = 2
  final val SPEED_DOWN = 3
  final val SWIM = 4
}

class Hero {
  private var state = Hero.COMMON
  private var runThread: Thread = _

  def setState(state: Int): Unit = {
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
    val hero: Hero = this
    runThread = new Thread(new Runnable {
      override def run(): Unit = {
        breakable {
          while (!runThread.isInterrupted) {
            try {
              hero.run()
            } catch {
              case _: InterruptedException => break()
            }
          }
        }
      }
    })
    println("------开始跑动------")
    runThread.start()
  }

  def run(): Unit = {
    if (state == Hero.SPEED_UP) {
      println("------加速跑动------")
      Thread.sleep(4000)
      state = Hero.COMMON
      println("------加速状态结束，变为正常状态------")
    } else if (state == Hero.SPEED_DOWN) {
      println("------减速跑动------")
      Thread.sleep(4000)
      state = Hero.COMMON
      println("------减速状态结束，变为正常状态------")
    } else if (state == Hero.SWIM) {
      println("------不能跑动------")
      Thread.sleep(2000)
      state = Hero.COMMON
      println("------眩晕状态结束，变为正常状态------")
    } else {
      // 正常
    }
  }
}
