package example

import akka.actor.Actor

class ServerActor extends Actor{
  override def receive: Receive = {
    case "start" => println("天猫系统已启动。。。")
//    case ClientMessage(msg) => {
//      println()
//    }
  }
}
