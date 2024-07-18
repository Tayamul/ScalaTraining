package Week3.Thurs

object ForComp extends App {

  /**
   *  '<-' backwards arrow syntax - means calling something
   *  it initiates a call
   */

  /** Classic */

  def retrieveNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers
  println(retrieveNumbers)

  def squareNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers * numbers
  println(squareNumbers)

  def ifGuardNumbers: Seq[Int] = for (numbers <- 1 to 10 if numbers % 2 == 0) yield numbers
  println(ifGuardNumbers)

  /* Never use println to test the method or even call the method just to see if it works!
  Always use the method where it's needed.
  OR LOG THE METHOD!
   */

  /** Use with case classes */
  sealed trait Colour
  case object Blue extends Colour
  case object Green extends Colour
  case object Yellow extends Colour

  case class Pencil (colour: Colour, sharpened: Boolean)
  def getPencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true, false)
  } yield Pencil(colour, sharpened)

  println(getPencils)

  /* Can't add extra bits, BUT leave some out */
  def getTruePencils: List[Pencil] = for {
    colour <- List(Blue, Green, Yellow)
    sharpened <- List(true)
  } yield Pencil(colour, sharpened)

  println(getTruePencils)
}
