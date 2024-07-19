package Week3.Fri

/** For future - global == lazy val (not executed until we call them!) */

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}

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

}
