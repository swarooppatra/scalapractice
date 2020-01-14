import java.io.File

1 + 1
println("Hello, world")

// dummy for command line argument
var args = List(10, 20, 30)
println("Hello, world " + args(1))

// while loop
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}

// functional prog way
args.foreach(arg => println(arg))

args.foreach((arg: Int) => println(arg))

args.foreach(println)

for (arg <- args) {
  println(arg)
}

val greetMessage = new Array[String](3)

greetMessage(0) = "Hello"
greetMessage(1) = ", "
greetMessage(2) = "world!\n"

for (i <- 0 to 2)
  print(greetMessage(i))

1.+(2)
(1).+(2)

val greetString = new Array[String](3)
greetString.update(0, "Hello")
greetString.update(1, ", ")
greetString.update(2, "world!\n")
for (j <- 0.to(2))
  print(greetString.apply(j))

val a1 = Array(1, 2)
val greet = Array("Hello", ", ", "world!\n", a1)
greet foreach print

val n1 = List(1, 2)
val n3 = List(3, 4)
println(n1 ::: n3)
println(0 :: n1)

val names = List("swaroop", "Anita", "Sourish")
names.count(name => name(0).isUpper)

var price = ("IceCream", 10.0)
println(price._1)
println(price._2)

var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))
jetSet.foreach(println)
println(jetSet)

import scala.collection.mutable

val movies = mutable.Set("Matrix", "Hello")
movies += "Frozen"
println(movies)

import scala.collection.mutable

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to fair island")
treasureMap += (2 -> "Find big X")
treasureMap += (3 -> "Dig...")
println(treasureMap(2))

val romanLetters = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "Iv", 5 -> "V")
println(romanLetters(3))

def formatArgs(args: List[String]) = args.mkString(" loves ")
println(formatArgs(names))

var test1 = formatArgs(List("a", "b", "c"))
assert(test1 == "a loves b loves c")

val arg1 = List("/Users/swaroop/git/scalapractice/src/test/sample.txt")

import scala.io.Source

if (arg1.nonEmpty) {
  for (line <- Source.fromFile(arg1(0)).getLines()) {
    println(line.length + " " + line)
  }
} else {
  Console.err.println("Please enter filename")
}

val lines = Source.fromFile(arg1(0)).getLines().toList
def widthOfLine(s: String) = s.length.toString.length
var maxWidth = 0
for (line <- lines)
  maxWidth = maxWidth.max(widthOfLine(line))

val longestLine = lines.reduceLeft(
  (a, b) => if (a.length > b.length) a else b
)
println(longestLine.length.toString.length)
var maxWidth1 = widthOfLine(longestLine)

for (line <- lines) {
  var spaces = maxWidth1 - widthOfLine(line)
  var padding = " " * spaces
  println(spaces+ padding)
  println(padding + line.length + "| " + line)
}

print(
  """Welcome to scala practice.
      Described in chapters""")

val r1 = new chapter6.Rational(1,2)

val filesHere = new File(".").listFiles()
for (file <- filesHere)
  println(file)



println("Filter for dir and print sh file name")
for(file <- filesHere if file.isFile if file.getName.endsWith("sh"))
  println(file)