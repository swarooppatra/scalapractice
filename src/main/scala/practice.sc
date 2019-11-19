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

