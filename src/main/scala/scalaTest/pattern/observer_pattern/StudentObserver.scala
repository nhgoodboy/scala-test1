package scalaTest.pattern.observer_pattern

import scalaTest.pattern.observer_pattern.my.Observer

class StudentObserver(private var name: String, private var t: TeacherSubject) extends Observer {

  t.addObserver(this)

  override def update(info: String): Unit = {
    println(name + "得到作业：" + info)
  }
}
