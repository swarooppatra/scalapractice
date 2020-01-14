package chapter4

object FallWinterSpringSummer extends App {
  for (season <- List("Fall", "Winter", "spring")) {
    println(season + ":" + ChecksumAccumulator.calculate(season))
  }
}
