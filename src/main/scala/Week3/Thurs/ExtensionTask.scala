package Week3.Thurs

import Week3.Thurs.ExtensionTask.Name.nameOrError
import Week3.Thurs.ExtensionTask.Postcode.postcodeOrError

object ExtensionTask extends App {

  /**
   * Create companion object to Name' and inside it
   * - Create a method called ' nameOrError'
   * - Use the name from the case class in the method
   * - Pass in a 'String' called ' maybeName'
   * - If the 'name' has a number in it, then return an 'InvalidNameError'
   * - If the above condition is not satisfied, return a 'Name'
   * - The overall return type of this method should be "Either[InvalidNameError, Name]'
   */

  case class Name (value: String)
  val Jamie: Name = Name("Jamie")

  object Name {

    def nameOrError (maybeName: String): Either[InvalidNameError, Name] = {

      maybeName match {
        case m if (m.exists(_.isDigit)) => Left(InvalidNameError.apply("Invalid name error!"))
        case _ => Right(Name.apply(maybeName))
      }

    }
  }
  println(Name.nameOrError(Jamie.value))

  /**
   * Create companion object (RESEARCH: what are these, why do we use them?) to PostCode and inside it
   * - Create a method called * postcodeOrError
   * - Pass in a String' called 'maybePostCode'
   * - If the ' maybePostCode ' is two "String's with a whitespace inbetween them, then return a 'Postcode
   * - If the above condition is not satisfied, return an 'InvalidPostcodeError'
   * - The overall return type of this method should be Either[InvalidPostcodeError,
   * */
  case class Postcode (value: String)
  object Postcode {

    def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
      val splitPostcode = maybePostCode.split(" ")

      splitPostcode match {
        case s if (s.forall(_.isEmpty)) => Left(InvalidPostcodeError.apply("Field cannot be left empty!"))
        case s if (s.length == 2 && s.forall(_.nonEmpty)) => Right(Postcode.apply(maybePostCode))
        case _ => Left(InvalidPostcodeError.apply("Invalid Postcode!"))
      }

    }
  }

  /**
   * 11. Create companion object to Letter' and inside it
   - Create a method called ' letterOrError'
   - Pass in two String's called maybeName' and 'maybePostCode'
   - In a for comprehension
   - Use the 'nameOrError and ' letterOrError' to create a ' Letter'
   - What should the return type be?
   */

  case class Letter (name: Name, postcode: Postcode)
  object Letter {

    def letterOrError (maybeName: String, maybePostCode: String): Either[GenericPostageError, Letter] = for {
      name <- nameOrError(maybeName)
      postcode <- postcodeOrError(maybePostCode)
    } yield Letter(name, postcode)

  }

  val letterWithANumberInAName = Letter.letterOrError("Roshan123", "B20 5JL")
  val letterWithAnInvalidPostcode = Letter.letterOrError("Roshan", "B205JL")
  val letterAllInvalid = Letter.letterOrError("Roshan532", "")
  println(letterWithANumberInAName)
  println(letterWithAnInvalidPostcode)
  println(letterAllInvalid)

  trait GenericPostageError {
    def message: String
  }
  case class InvalidNameError (message: String) extends GenericPostageError
  case class InvalidPostcodeError (message: String) extends GenericPostageError

  val letter: Either[Nothing, Letter] = Right(Letter.apply(name = Name("Vinnie"), postcode = Postcode("EC1V 2P")))
  val invalidLetter: Either[GenericPostageError, Nothing] = Left(InvalidNameError.apply(message = "Invalid name error!"))

  println(letter, "LETTER")
  println(invalidLetter, "INVALID LETTER")


}
