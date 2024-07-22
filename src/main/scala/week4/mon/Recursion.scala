package week4.mon

import scala.annotation.tailrec

object Recursion extends App {

  // Standard recursion
  // final call to being itself

  def factorial (n: Int): Int = {
    if (n <=1 ) {
      1
    } else {
//      println(s"Currently working on ${n-1}")
      val finalResult = n * factorial(n - 1)
//      println(s"I am the final call of $n")
      finalResult
    }
  }
  println("\nfactorial method (4) - standard recursion:")
  println(factorial(4))
//  println(factorial(400000000)) // stack overflow error - limited memory on the call stack

  /** Tail recursion
   * Helps stop the stack overflow error - by reusing the call stack rather than just adding to it.
   * Looks trickier because there's method within a method -
   * THE helper function reuses the method - the main method does not need to be used or worked on
   * "Helper function" - write all the method inside here, and only uses the main method for the 'last' call.
   * You can have multiple helper methods, or multiple accumulators
   * acc is going to store the data for us, rather than the call stack
   * */
  def smartFactorial (n: Int): Int = { // user doesn't need to think about passing in accumulator, everything is done with the helper function
    @tailrec
    def factorialHelper(x: Int, acc: Int): Int = { // helper method (has an accumulator + any additional params that may be needed during the recursion, but not in the original method)
      if (x <= 1) acc
      else {
        //        println(s"Current X: $x")
        //        println(s"Current acc: $acc")
        factorialHelper(x - 1, x * acc) // acc - holds the running total - storing that intermediate
      }
    }
    factorialHelper(n, 1)
  }
  println("\nFactorial (4) - tail rec:")
  println(smartFactorial(4))

  /** 1st call: factorialHelper(4-1, 4*1) = (3, 4)
   * 2nd call: factorialHelper(3-1, 3*(4*1)) = (2, 12)
   * 3rd call: factorialHelper(2, 2 * (3*(4*1))) = (1, 24)
   * 4th call: x == 1 ==> hitting the 'if' and returning the acc which is currently stored at 24.
   */
//  println(smartFactorial(400000))

  /**
   * Tail rec -> concatenate a string n times
   * Without the helper method
   */
    @tailrec
  def concatenateWords (aWord: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else {
      concatenateWords(aWord, n - 1, aWord + acc)
    }
  }
  println("\nTail rec - concatenate words")
  println(concatenateWords("hello ", 30, "BYE"))
}
