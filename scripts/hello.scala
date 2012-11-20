// Say hello to the first argument!
println("Hello " + args(0) + "!")

println("Print the arguments imperatively:");
var i = 0;
var array = while(i < args.length){
	println(args(i))
	i += 1
}

println("array = " + array) // This prints an empty array

println("Print the arguments scala way - functional:");
args.foreach(arg => println(arg))