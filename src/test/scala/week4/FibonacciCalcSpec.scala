package week4

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import week4.mon.FibonacciCalc

class FibonacciCalcSpec extends AnyWordSpec with Matchers {

  val fibonacciCalculator: FibonacciCalc = new FibonacciCalc()

  "fibonacciCalc" should {
    "return the Fibonacci Sequence" in {
      val result = fibonacciCalculator.fibonacciCalc(3)
      result shouldBe ""
    }
  }

}

