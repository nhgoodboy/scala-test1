package example

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn

class HelloActor extends Actor{
  override def receive: Receive = {
    case "so handsome" => println("i like you saying the truth")
    case "ugly" => println("get out")
    case "stop" =>
      context.stop(self)
      context.system.terminate()
  }
}

object HelloActor {
  private val MyFactory = ActorSystem("myFactory")
  private val helloActorRef = MyFactory.actorOf(Props[HelloActor], "helloActor")

  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag) {
      println("please insert what you want to send")
      val consoleLine: String = StdIn.readLine()
      helloActorRef ! consoleLine
      if (consoleLine.equals("stop")) {
        flag = false
        println("this program is ending")
      }
      Thread.sleep(100)
    }
  }
}