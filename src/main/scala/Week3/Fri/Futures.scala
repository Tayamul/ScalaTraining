package Week3.Fri

/** For future - global == lazy val (not executed until we call them!) */

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.concurrent.impl.Promise

object Futures extends App {

  /** Acts as a placeholder.
   * Computation will be resolved in the "future".*/

  def addition (x:Int, y: Int): Int = {
    Thread.sleep(1000) // for a computer, this is a long computation time.
    x + y
  }

  def additionInTheFuture: Future[Int] = Future {
    addition(1, 2)
  }

  val waitTime: FiniteDuration = Duration(5, TimeUnit.SECONDS)
  println(Await.result(additionInTheFuture, waitTime)) // this will block the main thread.

  class NewError (val errorCode: Int, val errorMessage: String) extends Exception
  case object IsOddError extends NewError (400, "Bad request in the is odd method")

  def isOdd (x: Int): Either[NewError, String] =
    if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)

//  println(isOdd(20))
//  println(isOdd(21))

  /** Either implemented with Futures */
  def fetchIsOddOrError (num: Int): Future[Either[NewError, String]] = Future {
    Thread.sleep(5000)
    isOdd(num)
  }

  def callFetchMethod: Future[Either[NewError, String]] = {
    fetchIsOddOrError(21)
  }

  def patternMatchingFutureMethod: String = callFetchMethod.value match {
    case Some(value) => s"Future method was a success: $value"
    case None => "Future timed out!"
  }

  println(patternMatchingFutureMethod)
//  println(Await.result(patternMatchingFutureMethod, waitTime))

}
