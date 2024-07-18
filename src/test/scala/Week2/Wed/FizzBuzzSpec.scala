package Week2.Wed

import org.scalatest.flatspec.AnyFlatSpec

class FizzBuzzSpec extends AnyFlatSpec {

  "fizzBuzz" should "return the word 'Fizz' if the input is divisible by 3" in {
    val result = new FizzBuzz(6)
    assert(result.fizzBuzz == "Fizz")
  }

  "fizzBuzz" should "return the word 'Buzz' if the input is divisible by 5" in {
    val result = new FizzBuzz(20)
    assert(result.fizzBuzz == "Buzz")
  }

  "fizzBuzz" should "return the word 'FizzBuzz' if the input is divisible by both 3 and 5" in {
    val result = new FizzBuzz(30)
    assert(result.fizzBuzz == "FizzBuzz")
  }

  "fizzBuzz" should "pass the test but return an appropriate error message if the input is 0" in {
    val result = new FizzBuzz(0)
    assert(result.fizzBuzz == "Input cannot be 0")
  }

  "fizzBuzz" should "return an error message if the input is a negative integer" in {
    val result = new FizzBuzz(-82)
    assert(result.fizzBuzz == "Negative numbers are not allowed")
  }

  "fizzBuzz" should "return an error message if the input is less than 3" in {
    val result = new FizzBuzz(2)
    assert(result.fizzBuzz == "The input must be 3 or higher")
  }

  "fizzBuzz" should "return an appropriate message if the input is not divisible by 3 and 5" in {
    val result = new FizzBuzz(22)
    assert(result.fizzBuzz == "The input is not divisible by 3 and 5")
  }

  "fizzBuzz" should "handle the smallest valid input greater than or equal to 3" in {
    val result = new FizzBuzz(3)
    assert(result.fizzBuzz == "Fizz")
  }

  "fizzBuzz" should "handle the smallest valid input greater than or equal to 5" in {
    val result = new FizzBuzz(5)
    assert(result.fizzBuzz == "Buzz")
  }

  "fizzBuzz" should "handle a large number divisible by 3" in {
    val result = new FizzBuzz(333)
    assert(result.fizzBuzz == "Fizz")
  }

  "fizzBuzz" should "handle a large number divisible by 5" in {
    val result = new FizzBuzz(1000000)
    assert(result.fizzBuzz == "Buzz")
  }

  "fizzBuzz" should "handle a large number divisible by 3 and 5" in {
    val result = new FizzBuzz(900)
    assert(result.fizzBuzz == "FizzBuzz")
  }

  "fizzBuzz" should "handle a large number not divisible by 3 or 5" in {
    val result = new FizzBuzz(1001)
    assert(result.fizzBuzz == "The input is not divisible by 3 and 5")
  }

}
