package Week2.Wed

class FizzBuzz (num: Int) {

  def fizzBuzz: String = {
    if (num == 0) "Input cannot be 0"
    else if (num < 0) "Negative numbers are not allowed"
    else if (num < 3 ) "The input must be 3 or higher"
    else if (num % 3 == 0 && num % 5 == 0) "FizzBuzz"
    else if (num % 5 == 0) "Buzz"
    else if (num % 3 == 0) "Fizz"
    else "The input is not divisible by 3 and 5"
  }

}