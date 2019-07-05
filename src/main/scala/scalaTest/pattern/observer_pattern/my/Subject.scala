package scalaTest.pattern.observer_pattern.my

trait Subject {

  def addObserver(obj: Observer)

  def deleteObserver(obj: Observer)

  def notifyObserver()

}
