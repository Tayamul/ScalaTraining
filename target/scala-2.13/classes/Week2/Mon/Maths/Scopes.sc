trait Numbers {
  val one = 1
  val two = 2
  val three = 3

  def addOneAndThree(): Int = {
    one + three
  }

  def addNumAndTwo(num: Int): Int = {
    num + two
  }
}


object Subtractions extends Numbers {
  def subtractNumFromFour (num: Int) = {
    addOneAndThree - num
  }

  def subtractNumAndFive (num: Int) = {
    addNumAndTwo(num) - 5
  }
}

Subtractions.subtractNumFromFour(2)
Subtractions.subtractNumAndFive(18)

object Multiplications {
  val three = 3
  def multiplyNumAndThree (num: Int) = {
    num * Subtractions.three
  }

  def multiplyTwoAndThree = {
    import Subtractions.two
    two * three
  }

  def test = {
  Subtractions.addOneAndThree()
  }
}

Multiplications.multiplyTwoAndThree
Multiplications.multiplyNumAndThree(4)
Multiplications.test