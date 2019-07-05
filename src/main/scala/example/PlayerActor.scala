package example

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class PlayerActor(val p2: ActorRef) extends Actor{
  override def receive: Receive = {
    case "start" =>
      println("I'm ok!")
      p2 ! "it is turn to you"
    case "fuck" =>
      println("you so strong")
      Thread.sleep(1000)
      p2 ! "it is turn to you"
  }
}

class PlayerActor2 extends Actor{
  override def receive: Receive = {
    case "start" =>
      println("I'm ok!")
    case "it is turn to you" =>
      println("i must")
      Thread.sleep(1000)
      sender() ! "fuck"
  }
}

object CHineseChess extends App {
  private val ChineseChessActorSystem = ActorSystem("Chinese_chess")
  private val p2 = ChineseChessActorSystem.actorOf(Props[PlayerActor2], "player2")
  private val p1 = ChineseChessActorSystem.actorOf(Props(new PlayerActor(p2)), "player")

  p2 ! "start"
  p1 ! "start"

}