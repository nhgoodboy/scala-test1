package scalaTest.pattern.observer_pattern

object TestObserver {

  def main(args: Array[String]): Unit = {
    val teacher = new TeacherSubject
    val zhangSan = new StudentObserver("zhangSan", teacher)
    val liSi = new StudentObserver("liSi", teacher)
    val wangWu = new StudentObserver("wangWu", teacher)

    teacher.setHomework("第一页第一题")
    println()
    teacher.setHomework("第二页第六题")
    println()
    teacher.deleteObserver(liSi)
    teacher.setHomework("第三页第七题")

  }
}
