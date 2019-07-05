package scalaTest.pattern.command_pattern

object Client {

  def main(args: Array[String]): Unit = {
    val receiver = new Receiver
    val invoker = new Invoker
    invoker.setCommand(new ConcreteCommandA(receiver))
    invoker.runCommand()
    invoker.setCommand(new ConcreteCommandB(receiver))
    invoker.runCommand()
  }

}
