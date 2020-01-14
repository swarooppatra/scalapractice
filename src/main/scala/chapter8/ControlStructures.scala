package chapter8

import java.io.File

import scala.io.Source
import scala.util.{Try, Using}

object ControlStructures {

  def main(args: Array[String]): Unit = {
    val ctrlStru = new ControlStructures()
    ctrlStru.printFileNames()
    ctrlStru.printFilesByExtension("sbt")
    ctrlStru.grep("version", "sbt")
    ctrlStru.grep2("version", "sbt")
    println(ctrlStru.listFilesByExtension("sbt"))
    println(ctrlStru.lineLength("version", "sbt"))
  }
}

class ControlStructures {

  val filesHere: Array[File] = new File(".").listFiles()

  def printFileNames(): Unit = {
    for (file <- filesHere)
      println(file)
  }

  def printFilesByExtension(extension: String): Unit = {
    println("Files ending with sh")
    for (file <- filesHere if file.getName.endsWith(extension))
      println(file)
  }

  def fileLines(file: File): Try[List[String]] = {
    Using(Source.fromFile(file)) {
      _.getLines.toList
    }
  }

  def grep(pattern: String, extension: String): Unit = {
    for {
      file <- filesHere
      if file.getName.endsWith(extension)
      line <- fileLines(file).get
      if line.trim.contains(pattern)}
      println(s"""$file : ${line.trim} """)
  }

  def grep2(pattern: String, extension: String): Unit = {
    for {
      file <- filesHere
      if file.getName.endsWith(extension)
      line <- fileLines(file).get
      trimmed = line.trim
      if trimmed.contains(pattern)}
      println(s"""$file : ${trimmed} """)
  }

  def listFilesByExtension(extension: String): Array[File] = {
    for {
      file <- filesHere
      if file.getName.endsWith(extension)
    } yield file
  }

  def lineLength(pattern: String, extension: String): Array[Int] = {
    for {
      file <- filesHere
      if file.getName.endsWith(extension)
      line <- fileLines(file).get
      trimmedLine = line.trim
      if trimmedLine.contains(pattern)
    } yield trimmedLine.length
  }
}
