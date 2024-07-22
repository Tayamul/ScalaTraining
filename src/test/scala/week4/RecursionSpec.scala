package week4

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import week4.mon.Recursion._


class RecursionSpec extends AnyWordSpec with Matchers {
//  Recursion.concatenateWords()

  "concatenateWords" should {
    "return the acc if n is negative" in {
      val methodCall = concatenateWords("Hello", -1, "")
      val expectedResult = ""
      methodCall shouldEqual expectedResult
    }
    "return the acc if n is 0" in {
      concatenateWords("Hello", 0, "") shouldBe ""
    }
    "return a concatenated string of 'hello' 3 times if in is 3" in {
      concatenateWords("hello ", 3, "") shouldEqual  "hello hello hello "
    }
    // Edge case
    "concatenate an empty string" in {
      concatenateWords("", 3, "") shouldEqual ""
    }
    "concatenate words when the acc isn't empty" in {
      concatenateWords("hello ", 3, "appendMe") shouldEqual "hello hello hello appendMe"
    }
  }
}

