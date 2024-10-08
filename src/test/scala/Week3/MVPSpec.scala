package Week3

import Week3.Thurs.MVP._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MVPSpec extends AnyWordSpec with Matchers {

  // individual with not enough deposit
  val Dave: Person = Person(name = "Dave",  income = 45000, deposit = 20000, priceOfFlat = 280000, creditScore = 577)
  val incomeX4: Double = Dave.income * 4

  // individual that does not meet the credit score requirement
  val Jake: Person = Person(name = "Jake",  income = 45000, deposit = 50000, priceOfFlat = 280000, creditScore = 450)

  // individual eligible for mortgage
  val Paul: Person = Person(name = "Paul",  income = 45000, deposit = 60000, priceOfFlat = 280000, creditScore = 550)

  // individual not meeting any of the requirements
  val Mike: Person = Person(name = "Mike",  income = 4000, deposit = 6000, priceOfFlat = 300000, creditScore = 444)

  "getMaxMortgage" should {
    "return a Right" when {
      "return the salary amount multiplied by 4" in {
        val income = 20000
        val expected = income * 4
        getMaxMortgage(income) shouldBe Right(expected)
        }
    }
    "return a Left" when {
      "the income is set to 0" in {
        getMaxMortgage(0) shouldBe Left("Input cannot be 0.")
      }
      "return 0 if the input is a negative integer" in {
        getMaxMortgage(-35000) shouldBe Left("Input cannot be a negative integer.")
      }
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
        checkCreditScore(-300) shouldBe Left("Input cannot be a negative integer.")
      }
      "the credit score is above the highest possible value" in {
        checkCreditScore(1200) shouldBe Left("The value is unrealistic.")
      }
    }
  }

  "getMortgage" should {
    "return a Right" when {
      "the credit score meets the minimum requirement" in {
        getMortgage(Dave) shouldBe Right(s"${Dave.name} can obtain the maximum mortgage of £${incomeX4}.")
      }
    }
    "return a Left" when {
      "the credit score is below the minimum requirement" in {
        getMortgage(Jake) shouldBe Left("The individual does not meet the minimum credit score requirement.")
      }
    }
  }

  "isDepositEnough" should {
    "return a Right" when {
      "the deposit amount is at least 10% of the purchase price" in {
        val deposit: Double = 50000
        val purchasePrice: Double = 200000
        isDepositEnough(deposit, purchasePrice) shouldBe Right(deposit)
      }
    }
    "return a Left" when {
      "the deposit amount is less than 10% of the purchase price" in {
        val deposit: Double = 500
        val purchasePrice: Double = 200000
        isDepositEnough(deposit, purchasePrice) shouldBe Left(s"The deposit £${deposit} is less than 10% of the purchase price £${purchasePrice}.")
      }
    }
  }

  "isEligibleForMortgage" should {
    "return a Right" when {
      "the individual meets all the requirement" in {
        isEligibleForMortgage(Paul) shouldBe Right(s"${Paul.name} can get a mortgage of ${Paul.priceOfFlat - Paul.deposit}.")
      }
    }
    "return a Left" when {
      "the individual does not meet any of the requirements" in {
        // The specific error message occurs because our initial check verifies whether the individual's deposit amount meets the required criteria.
        isEligibleForMortgage(Mike) shouldBe Left(s"The deposit £${Mike.deposit} is less than 10% of the purchase price £${Mike.priceOfFlat}.")
      }
    }
  }

}
