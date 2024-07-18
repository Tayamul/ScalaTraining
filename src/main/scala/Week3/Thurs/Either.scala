package Week3.Thurs

import java.time.LocalDate

object Either extends App {

  /**
   * Left - error (always consider the error cases first)
   * Right - success
   * */

  def isEven (x: Int): Either[String, String] =
    if (x % 2 == 0) Right(s"$x is even") else Left(s"$x is odd")
      // make sure when testing, assertion is 'right' or 'left', NOT just a string or a boolean for example.
println(isEven(18))
println(isEven(21))

  // Custom error
  class NewError (val errorCode: Int, val errorMessage: String) extends Exception
  case object IsOddError extends NewError (400, "Bad request in the is odd method")

  def isOdd (x: Int): Either[NewError, String] =
    if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)

  println(isOdd(20))
  println(isOdd(21))

  /** Try/catch */
  def plusOne(x: String): Either[String, Int] = {
    try {
      Right(x.toInt)
    } catch {
      case e: Exception => Left(s"Failed due to: $e") // wildcard for try/catch. EXCEPTION library to print out the exact result
    }
  }
  println(plusOne("1")) // Right - try
//  println(plusOne("one")) // Left - catch

  // you can call functions directly
  plusOne("3").map(num => num + 1)
//  plusOne("I will fail").map(num => num + 1)


  /** Pattern Matching */
  def plusOneMatch(): Unit = {
    plusOne("one") match {
      case Left(e) => println(s"Left: $e")
      case Right(x) => println(s"Right: $x")
    }
  }
    println(plusOneMatch())


  /** For comps with eithers
   * Fail fast - as soon as one condition is not met == exit
   * compilation time is quicker
   * if/else goes through very condition? - that's why compile time is longer!
   * */

  case class User (username: String, password: String, dateOfBirth: LocalDate)

  case class ValidatedUser (username: String, password: String, dateOfBirth: LocalDate) // return type

  /*
  Validate the username
  Validate the password
  Validate the age
  Combine all three and validate the whole user
   */

// Validate the username
  def validateUsername (username: String): Either[String, String] = { // alternatively create a user case class and infer the username's type as User case class.
    if (username.length <= 12) Left("Username must be at least 12 characters.")
    else Right (username)
  }

  // Validate the password
  def validatePassword (password: String): Either[String, String] = {
    if (password.toUpperCase == password || password.toLowerCase == password) Left("Password must be a mixture of upper and lower case.")
    else Right(password)
  }

  // Validate the age
  def validateAge (dateOfBirth: LocalDate): Either[String, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now())) Left("User must be 18 years old.")
    else Right(dateOfBirth)
  }

  // Combine all 3 and validate whole user as for comp

  def validateUser (user: User): Either[String, ValidatedUser] =
    for {
      username <- validateUsername(user.username)
      password <- validatePassword(user.password)
      dateOfBirth <- validateAge(user.dateOfBirth)
      createValidatedUser = ValidatedUser(username, password, dateOfBirth) // creation of the case class
    } yield createValidatedUser // yielding the case class (only if all method above hit the 'right')

  val usernameBad = User("April", "PassworD", LocalDate.of(1995,2,16))
  val passwordBad = User("AprilGarlington", "password", LocalDate.of(1995,2,16))
  val dobBad = User("AprilGarlington", "PassworD", LocalDate.of(2023,2,16))
  val goodUser = User("AprilGarlington", "PassworD", LocalDate.of(1995,2,16))

  println(validateUser(usernameBad))
  println(validateUser(passwordBad))
  println(validateUser(dobBad))
  println(validateUser(goodUser))
}
