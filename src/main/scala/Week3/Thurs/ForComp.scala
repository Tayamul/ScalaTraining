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

/** Task1 */
//sealed trait Name
//case object Tom extends Name
//case object Roshan extends Name
//case object Joe extends Name
//case object Spencer extends Name

//  case class Person (name: Name)
//def namesToCapital (listOfNames: List[String]): List[Person] = for {
//  listOfNames <- List(listOfNames map (_.toUpperCase()))
//} yield listOfNames

  def namesToCapital (names: List[String]): List[String] = {
    for {
      names <- names.map(x => x.toUpperCase)
    } yield names
  }
  println(namesToCapital(List("tom", "arie", "spencer", "joe")))

  def capitaliseNames (names: List[String]): List[String] = {
    val lowercaseNames = names.map(x => x.toLowerCase())
    for {
      names <- lowercaseNames.map(x => x.capitalize)
    } yield names
  }
  println(capitaliseNames(List("tom", "arie", "spencer", "joe")))

}

