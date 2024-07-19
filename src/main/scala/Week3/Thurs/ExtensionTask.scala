package Week3.Thurs

object ExtensionTask extends App {

  case class Name (value: String)
  case class Postcode (value: String)

  case class Letter (name: Name, postcode: Postcode)

  trait GenericPostageError {
    def message: String
  }
  case class InvalidNameError (message: String) extends GenericPostageError
  case class InvalidPostcodeError (message: String) extends GenericPostageError

  val letter: Either[Nothing, Letter] = Right(Letter.apply(name = Name("Vinnie"), postcode = Postcode("EC1V 2P")))
  val invalidLetter: Either[GenericPostageError, Nothing] = Left(InvalidNameError.apply(message = "Invalid name error!"))

}
