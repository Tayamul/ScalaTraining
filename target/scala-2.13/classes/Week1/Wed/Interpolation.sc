// s interpolation

val name: String = "Tayamul"
println(s"My name is $name")

println(s"3 x 3 = ${3*3}")

val num: Int = 7
println(s"$num x $num = ${num*num}")

/*
%f - floating point number
%d - decimal
%i - int
 */

val pi: Double = 3.1415926535897
println(f"Pi to 2dp is $pi%.2f")
println(f"Pi to 4dp is $pi%.4f")

printf("'%s", name)
printf("'%s'", name)
printf("'%16s'", name)
printf("'%-16s'", name)

// Raw
println(raw"hello \nworld")

// Task 1
val name1: String = "Jordan"
val name2: String = "Jack"

println(s"$name2 is older than $name1.")

// Task 2
val jordansAge: Double = 21.689
val jacksAge: Double = 32.5296

println(s"$name2 is ${jacksAge-jordansAge} years older than $name1.")

// Task 3
val jordansAge2: Double = 21.689
val jacksAge2: Double = 32.5296
println(f"$name2 is ${jacksAge2-jordansAge2}%.2f years older than $name1.")

// Task 4
println(raw"\n\n\n\n\n\n\nsameline\n\n")

val height: Double = 1.6
println(f"$name1's height is $height" + "m.")
printf("$name1's height is $height" + "m.")