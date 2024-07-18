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

  def isEligibleForMortgage (person: Person): Either[String, String] = {
    val mortgage: Double = person.priceOfFlat - person.deposit
    val incomeX4: Double = person.income * 4

    if (incomeX4 < mortgage) Left(s"${person.name} is NOT eligible for mortgage.")
    else Right(s"${person.name} is eligible for mortgage.")
  }

}
