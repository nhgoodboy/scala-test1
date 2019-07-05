package scalaTest.pattern.command_pattern

class ConcreteCommandA(private val receiver: Receiver) extends TCommand {

  override def execute(): Unit = {
    receiver.doA()
  }

}
