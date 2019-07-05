package scalaTest.pattern.command_pattern

class Invoker {

  private var command: TCommand = _

  def setCommand(command: TCommand): Unit = {
    this.command = command
  }

  def runCommand(): Unit = {
    command.execute()
  }
}
