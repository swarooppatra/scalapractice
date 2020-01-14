package chapter4

object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg + ":" + ChecksumAccumulator.calculate(arg))
  }
}
