package Week2.Mon.Maths

object Multiplications {
  val four = 3
  def multiplyNumAndThree (num: Int) = {
    num * Subtractions.three
  }

  def multiplyTwoAndThree = {
    import Subtractions._
    two * three
  }
}

