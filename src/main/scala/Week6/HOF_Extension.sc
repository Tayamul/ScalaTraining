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