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