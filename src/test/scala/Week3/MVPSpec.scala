package Week3

import Week3.Thurs.MVP._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MVPSpec extends AnyWordSpec with Matchers {

  val Dave: Person = Person(name = "Dave",  income = 80000, deposit = 20000, priceOfFlat = 280000, creditScore = 577)
  val mortgage: Double = Dave.priceOfFlat - Dave.deposit
  val incomeX4: Double = Dave.income * 4

  "isEligibleForMortgage" should {
    "return a Left" when {
      "the yearly income is less than four times the mortgage amount" in {
        isEligibleForMortgage(Dave) shouldBe Left(s"${Dave.name} is not eligible for mortgage.")
      }
    }
    "return a Right" when {
      "the yearly income is more than four times the mortgage amount" in {
        isEligibleForMortgage(Dave) shouldBe Right(s"${Dave.name} is eligible for mortgage.")
      }
    }
  }
}
