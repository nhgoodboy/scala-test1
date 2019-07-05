package scalaTest.pattern.observer_pattern

import scalaTest.pattern.observer_pattern.my.{Observer, Subject}

import scala.collection.mutable

class TeacherSubject extends Subject {

  private var observers = mutable.ListBuffer.empty[Observer]
  private var info: String = _

  override def addObserver(obj: Observer): Unit = {
    observers += obj
  }

  override def deleteObserver(obj: Observer): Unit = {
    if (observers.contains(obj)) {
      observers -= obj
    }
  }

  override def notifyObserver(): Unit = {
    for (item <- observers) {
      item.update(info)
    }
  }

  def setHomework(info: String): Unit = {
    this.info = info
    println("今天的作业是：" + info)
    this.notifyObserver()
  }
}
