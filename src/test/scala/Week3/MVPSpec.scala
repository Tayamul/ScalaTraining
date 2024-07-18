package Week3

import Week3.Thurs.MVP._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MVPSpec extends AnyWordSpec with Matchers {

  val Dave: Person = Person(name = "Dave",  income = 80000, deposit = 20000, priceOfHouse = 280000, creditScore = 577)
  val mortgage: Double = Dave.priceOfHouse - Dave.deposit
  val incomeX4: Double = Dave.income * 4

  "getMaxMortgage" should {
    "return the salary amount multiplied by 4" in {
      val income = 20000
      val expected = income * 4
      getMaxMortgage(income) shouldBe expected
      }
    "return 0 if the input is 0" in {
      getMaxMortgage(0) shouldBe 0
    }
    "return 0 if the input is a negative integer" in {
      getMaxMortgage(-35000) shouldBe 0
    }
  }

  "checkCreditScore" should {
    "return a Right" when {
      "the credit score is more than 550" in {
        checkCreditScore(600) shouldBe Right(600)
      }
      "the credit score is exactly 550" in {
        checkCreditScore(550) shouldBe Right(550)
      }
      "the credit score is at its highest possible value" in {
        checkCreditScore(999) shouldBe Right(999)
      }
      "the credit score is just below its highest possible value" in {
        checkCreditScore(998) shouldBe Right(998)
      }
    }

    "return a Left" when {
      "the credit score is below 550" in {
        checkCreditScore(250) shouldBe Left("The individual does not meet the minimum credit score requirement.")
      }
      "the credit score is just below 550" in {
        checkCreditScore(549) shouldBe Left("The individual does not meet the minimum credit score requirement.")
      }
      "the credit score is 0" in {
        checkCreditScore(0) shouldBe Left("Input cannot be 0.")
      }
      "the input is a negative integer" in {
        checkCreditScore(-300) shouldBe Left("Cannot input a negative integer.")
      }
      "the credit score is above the highest possible value" in {
        checkCreditScore(1200) shouldBe Left("The value is unrealistic.")
      }
    }
  }
}
