/**
 * Task 2
 * Write pure function(s) to return the Fibonacci sequence up to a given "n". Use 3 and 4 as the start terms, for example: Seq (3, 4, 7, 11, 18, ...)
 * */
def fibonacci(n: Int): Seq[Int] = {
  require(n >= 1, "n must be greater than or equal to 1")

  def loop(a: Int, b: Int, count: Int, acc: Seq[Int]): Seq[Int] = {
    if (count == n) acc
    else loop(b, a + b, count + 1, acc :+ (a + b))
  }

  if (n == 1) Seq(3)
  else if (n == 2) Seq(3, 4)
  else loop(3, 4, 2, Seq(3, 4))
}


fibonacci(4)