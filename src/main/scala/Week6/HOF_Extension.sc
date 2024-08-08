import scala.math.max

/** Extension & Research */

/**
 * Task 1.
 * Create a function called "max" that takes two Doubles and returns the maximum of the two numbers. (HINT: research and use the method, max)
 * Create a function called "maxListNum" that takes a list of doubles and the "max" function. It should return the largest number in the list. (HINT: research and use the reduce) method)
 */

def max(num1: Double, num2: Double): Double = math.max(num1, num2)
max(2, 20)

val doublesList: List[Double] = List(21, 76, 46, 99, 7, 124)
def maxListNum(listOfDoubles: List[Double], function: (Double, Double) => Double ): Double = {
  listOfDoubles.reduce(function)
}
maxListNum(doublesList, max)


/**
 * Task 2.
 * Create a function named 'applyFunc' that takes two parameters; a function of type Int => Int and an Int value. The 'applyFunc' should apply the function to the integer and return the result.
 * Create two functions, one named 'double' that doubles the input number, and one named 'square' that squares the input number.
 * Use the 'applyFunc' to apply the 'double' and 'square' methods to the number 5 and print the result.
 */

def applyFunc(function: Int => Int, num: Int): Int = {
  function(num)
}

def double(num: Int): Int = {
  num + num
}
def square(num: Int): Int = {
  num * num
}

val doubledResult = applyFunc(double, 5)
val squaredResult = applyFunc(square, 5)
s"The double of 5 is: $doubledResult"
s"The square of 5 is: $squaredResult"