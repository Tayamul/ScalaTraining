package Week2.Wed

import org.scalatest.flatspec.AnyFlatSpec

class TwoNumbersSpec extends AnyFlatSpec {

  "add" should "add numbers" in {
    val nums = new TwoNumbers(1, 2) // new instance of the class
    assert(nums.add == 3)
  }

  "subtractYFromX" should "subtract numbers" in {
    val nums = new TwoNumbers(5, 3)
    assert(nums.subtractYFromX == 2)
  }

  "subtractXFromY" should "subtract numbers" in {
    val nums = new TwoNumbers(5, 3)
    assert(nums.subtractXFromY == -2)
  }

  "multiply" should "multiple numbers" in {
    val nums = new TwoNumbers(1, 2)
    assert(nums.multiply == 2)
  }

  "divideXByY" should "divide X by Y" in {
    val nums = new TwoNumbers(15, 3)
    assert(nums.divideXByY == 5)
  }

  "divideYByX" should "divide Y by X" in {
    val nums = new TwoNumbers(10, 20)
    assert(nums.divideYByX == 2)
  }

  "isAMultiple" should "return true when one number is a multiple of another number" in {
    val nums = new TwoNumbers(15,3)
    assert(nums.isAMultiple)
  }

  "isAMultiple" should "return false when one number is not a multiple of another number" in {
    val nums = new TwoNumbers(14,3)
    assert(!nums.isAMultiple)
  }
}
