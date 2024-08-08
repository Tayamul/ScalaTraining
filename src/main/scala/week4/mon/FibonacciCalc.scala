package week4.mon

import scala.annotation.tailrec

class FibonacciCalc {

  def fibonacciCalc(num: Int): Either[List[Int], List[Int]] = {
    @tailrec
    def helperFibCalc(num1: Int, num2: Int, acc: List[Int]): Either[List[Int], List[Int]] = {
      if (num1 <= 0) Left(acc)
      else {
        helperFibCalc(num, num2, acc :+ num2)
      }
    }

    helperFibCalc(num, num + 1, List(1))
  }

//  println(fibonacciCalc(5))


}