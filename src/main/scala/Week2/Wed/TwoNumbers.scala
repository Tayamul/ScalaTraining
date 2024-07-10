package Week2.Wed

class TwoNumbers (x: Int, y: Int) {

  def add(): Int = {
    x + y
  } // ??? == empty implementation

  def subtractYFromX(): Int = {
    x - y
  }

  def subtractXFromY(): Int = {
    y - x
  }

  def multiply(): Int = {
    x * y
  }

  def divideXByY(): Int = {
    x / y
  }

  def divideYByX(): Int = {
    y / x
  }

  def isAMultiple(): Boolean = {
    x % y == 0
  }

}
