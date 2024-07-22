package Week3.Fri

import Week3.Thurs.ExtensionTask.Letter.letterOrError
import Week3.Thurs.ExtensionTask.{GenericPostageError, Letter}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object FuturesExtension extends App {

  implicit val ec: ExecutionContext = ExecutionContext.global

  def fetchLetterOrError (name: String, postCode:String): Future[Either[GenericPostageError, Letter]] = Future {
    Thread.sleep(1000)
    letterOrError(name, postCode)
  }

  val eventualLetterOrError = fetchLetterOrError("", "B20 7JL")

  def checkError: String = eventualLetterOrError.value match {
    case Some(Success(letter)) => s"Letter received: $letter"
    case Some(Failure(exception)) => s"The future completed with exception: $exception"
    case None => "The future did not complete"
  }

  println(Await.ready(eventualLetterOrError, 2.seconds))
  println(checkError)
}
