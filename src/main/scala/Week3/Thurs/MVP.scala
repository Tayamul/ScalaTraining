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

  case class Person (name: String, income: Double, deposit: Double, priceOfHouse: Double, creditScore: Double)
  val Samantha: Person = Person(name = "Samantha", income = 45000, deposit = 20000, priceOfHouse = 280000, creditScore = 577)

  def isEligibleForMortgage (person: Person): Either[String, String] = {
    val mortgage: Double = person.priceOfHouse - person.deposit
    val incomeX4: Double = person.income * 4

    if (incomeX4 < mortgage) Left(s"${person.name} is NOT eligible for mortgage.")
    else Right(s"${person.name} is eligible for mortgage.")
  }

//  def acceptableDeposit (deposit: Double): Either[String, String] = {
//
//  }

  def checkCreditScore (creditScore: Double): Either[String, Double] = {
    // for edge cases - can the creditScore's value ever be 0 or a negative integer?
    // what about the highest credit score value?

    creditScore match {
      case c if c < 0 => Left("Cannot input a negative integer.")
      case 0 => Left("Input cannot be 0.")
      case c if (c <= 999 && c >= 550) => Right(creditScore)
      case c if c <= 550 => Left("The individual does not meet the minimum credit score requirement.")
      case c if c > 999 => Left("The value is unrealistic.")
    }
  }
}
