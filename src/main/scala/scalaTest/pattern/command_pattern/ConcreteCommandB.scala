package scalaTest.pattern.command_pattern

class ConcreteCommandB(private val receiver: Receiver) extends TCommand {

  override def execute(): Unit = {
    receiver.doB()
  }

}
