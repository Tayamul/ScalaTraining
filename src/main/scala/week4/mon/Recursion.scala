package week4.mon

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

}
