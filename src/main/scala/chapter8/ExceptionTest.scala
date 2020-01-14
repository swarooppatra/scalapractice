package chapter8

import java.io.{FileNotFoundException, FileReader, IOException}
import java.net.{MalformedURLException, URL}

class ExceptionTest {

}

object ExceptionTest {

  def main(args: Array[String]): Unit = {
    try {
      val file = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => println(ex)
      case ex: IOException => println(ex)
      case ex: Exception => println(ex)
    } finally {
      println("finally")
    }

    println(validURL("abc"))
    println(validURL("http://www.cricinfo.com"))

  }

  def validURL(path: String): URL = {
    try {
      new URL(path)
    } catch {
      case ex: MalformedURLException =>
        new URL("https://www.google.com")
    }
  }
}