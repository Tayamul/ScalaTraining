package Week3.Thurs

/**
 * Samantha wants to buy a flat.
 * She earns £45,000 per annum and has a deposit of £20,000.
 * The flat she wants to buy is £280,000.
 * Her credit score is 577.

 * Conditions:
 * Mortgage = x4 salary per annum
 * Deposit = 10% of purchase price
 * Minimum credit score to qualify for a mortgage = 550

 * Write the logic to validate whether:
 * a) she is able to get a mortgage and if so, how much can she borrow?
 * b) she can purchase her flat at the current asking price.
 * c) Write a test spec
 */

object MVP extends App {

  case class Person (name: String, income: Double, deposit: Double, priceOfFlat: Double, creditScore: Double)

  val Samantha: Person = Person(name = "Samantha", income = 45000, deposit = 20000, priceOfFlat = 280000, creditScore = 577)
  object JHus extends Person(name = "JHus", income = 200000, deposit = 160000, priceOfFlat = 1500000, creditScore = 890)
  object DiggaD extends Person(name = "DiggaD", income = 100000, deposit = 20000, priceOfFlat = 250000, creditScore = 768)
  object Stormzy extends Person(name = "Stormzy", income = 85000, deposit = 50000, priceOfFlat = 450000, creditScore = 489)

  def getMaxMortgage (income: Double): Either[String, Double] = {
//    if (income <= 0) 0 else income * 4
    income match {
      case i if i < 0 => Left("Input cannot be a negative integer.")
      case 0 => Left("Input cannot be 0.")
      case i => Right(i * 4)
    }
  }

  def checkCreditScore (creditScore: Double): Either[String, Double] = {
    // for edge cases - can the creditScore's value ever be 0 or a negative integer?
    // what about the highest credit score value?

    creditScore match {
      case c if c < 0 => Left("Input cannot be a negative integer.")
      case 0 => Left("Input cannot be 0.")
      case c if (c <= 999 && c >= 550) => Right(creditScore)
      case c if c <= 550 => Left("The individual does not meet the minimum credit score requirement.")
      case c if c > 999 => Left("The value is unrealistic.")
    }
  }

  def getMortgage (person: Person): Either[String, String] = {
    for {
      creditScore <- checkCreditScore(person.creditScore)
      incomeX4 <- getMaxMortgage(person.income)
    } yield s"${person.name} can obtain the maximum mortgage of £${incomeX4}."
  }

  def isDepositEnough (deposit: Double, purchasePrice: Double): Either[String, Double] = {
    val requiredDeposit = 0.1 * purchasePrice

    if (deposit >= requiredDeposit) Right(deposit) else Left(s"The deposit £${deposit} is less than 10% of the purchase price £${purchasePrice}.")
  }

  def isEligibleForMortgage (person: Person): Either[String, String] = {
    for {
      enoughDepositOrNot <- isDepositEnough(person.deposit, person.priceOfFlat)
      getMortgageOrNot <- getMortgage(person)
    } yield s"${person.name} can get a mortgage of ${person.priceOfFlat - person.deposit}."
  }

  println(isEligibleForMortgage(Samantha))
  println(isEligibleForMortgage(JHus))
  println(isEligibleForMortgage(DiggaD))
  println(isEligibleForMortgage(Stormzy))
}
