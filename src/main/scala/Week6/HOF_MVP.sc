/** MVP 1 - passing a function as an argument */

/**
 * Task 1a
 * Create a function that takes an Int input and manipulates it to return a different Int value.
 * Create a second function called 'applyTwice' that takes two arguments.
 * One of the arguments is an Int input.
 * The other argument is an Int to Int function (made in step one).
 * The applyTwice function must apply the Int to Int function argument twice to the Int argument.
 */

def multiplyBy4(num: Int): Int = num * 4

def applyTwice(number: Int, function: Int => Int): Int = {
  function(number)
}
applyTwice(2, multiplyBy4)
applyTwice(10, multiplyBy4)

/**
 * Task 1b
 * • Create 4 functions (addition, multiplication, division, subtraction), each take two doubles as an input and return the result.
 * • Create a function called 'mathFunc' that takes in two doubles, and a mathematical operation (as made above) as a function and returns the result as a double.
 */

def addition(num1: Double, num2: Double): Double = {
  num1 + num2
}

def multiplication(num1: Double, num2: Double): Double = {
  num1 * num2
}

def division(num1: Double, num2: Double): Double = {
  num1 / num2
}

def subtraction(num1: Double, num2: Double): Double = {
  num1 - num2
}

def mathFunc(x: Double, y: Double, function: (Double, Double) => Double): Double = {
  function(x,y)
}

val add = mathFunc(2, 3, addition)
val multiply = mathFunc(2, 3, multiplication)
val divide = mathFunc(2, 3, division)
val subtract = mathFunc(2, 3, subtraction)


/** MVP 2 - returning a function */

/**
 * Task 2a
 * Create a function called 'convertToUpperCase' that take any string input, and returns that string as uppercase.
 * Create a function called 'convertToLowerCase' that take any string input, and returns that string as lowercase.
 * Create a third function called 'convertString' that takes a Boolean input with parameter name
 * 'makeStringUpperCase'. If the input is 'true' return the lst upperCase method, if false return the 2nd lowerCase method.
 * Copy: val testString = "cOnVeRtMe". Apply your convertString method to your testString and print the result when the input is 'true' and when it is 'false'.
 */

def convertToUpperCase(str: String): String = str.toUpperCase
def convertToLowerCase(str: String): String = str.toLowerCase

def convertString(string: String, makeStringUpperCase: Boolean): String = {
  /* makeStringUpperCase match {
    case true => convertToUpperCase(string)
    case false => convertToLowerCase(string)
  } */

  /* 'reason for using if/else statement instead of pattern match' - got a warning, trivial match can be simplified */
  if (makeStringUpperCase) {
    convertToUpperCase(string)
  } else {
    convertToLowerCase(string)
  }
}

val testString = "cOnVeRtMe"
convertString(testString, makeStringUpperCase = true)
convertString(testString, makeStringUpperCase = false)


/**
 * Task 2b
 * Create a 'calculate' method that takes a string input and pattern matches it to return one previously written methods from question 1; 'add', 'subtract', 'multiply', and 'divide'.
 * Try applying different string inputs to the calculate method to return each of the arithmetic methods, saving the resulting method to a val. What happens if you enter an input that doesn't match any of the methods?
 * Apply the val methods (from above), passing in two Int values. Print the result using s interpolation.
 */

def calculate(operation: String): (Double, Double) => Double = {
  operation.toLowerCase().trim() match {
    case "add" => addition
    case "subtract" => subtraction
    case "multiply" => multiplication
    case "divide" => division
    case _ => (num1: Double, num2: Double) => throw new IllegalArgumentException("Unknown operation")
  }
}

val addMethod= calculate("add")
val subtractMethod = calculate("SUBTRACT")
val multiplyMethod = calculate("mUlTiPlY")
val divideMethod = calculate("Divide  ")
val badRequest = calculate("modulus")

val num1: Double = 7
val num2: Double = 3

println(s"Adding $num1 and $num2 equals ${addMethod(num1, num2)}")
println(s"Subtracting $num1 by $num2 equals ${subtractMethod(num1, num2)}")
println(s"Multiplying $num1 and $num2 equals ${multiplyMethod(num1, num2)}")
println(f"Dividing $num1 by $num2 equals ${divideMethod(num1, num2)}%.2f")
println("---Bad request result---")
println(s"${badRequest(num1, num2)}")