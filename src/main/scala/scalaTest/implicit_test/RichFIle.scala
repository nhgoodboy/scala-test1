package scalaTest.implicit_test

import java.io.File

import scala.io.Source

class RichFIle(val file: File) {

  def read = {
    Source.fromFile(file.getPath).mkString
  }
}

object Context {
  implicit def file2RichFIle(file: File) = new RichFIle(file)
}

object Hello_Implicit_Conversions {
  def main(args: Array[String]): Unit = {
    import Context.file2RichFIle
    println(new File("E:\\1.txt").read)
  }
}

