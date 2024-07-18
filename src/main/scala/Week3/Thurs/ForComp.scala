package Week3.Thurs

object ForComp extends App {

  /**
   *  '<-' backwards arrow syntax - means calling something
   *  it initiates a call
   */

  /** Classic */

  def retrieveNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers
  println(retrieveNumbers)

}
