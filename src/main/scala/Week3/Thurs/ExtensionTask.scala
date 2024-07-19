package Week3.Thurs

object ExtensionTask extends App {

    /**
     * Create companion object (RESEARCH: what are these, why do we use them?) to PostCode and inside it
     * - Create a method called * postcodeOrError
     * - Pass in a String' called 'maybePostCode'
     * - If the ' maybePostCode ' is two "String's with a whitespace inbetween them, then return a 'Postcode
     * - If the above condition is not satisfied, return an 'InvalidPostcodeError'
     * - The overall return type of this method should be Either[InvalidPostcodeError,
     * */

  case class Name (value: String)
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


  case class Letter (name: Name, postcode: Postcode)

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
