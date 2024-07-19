package Week3.Fri

import Week3.Thurs.ExtensionTask.{Letter, Name, Postcode}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object FuturesMVP extends App {

  implicit val ec: ExecutionContext = ExecutionContext.global

  def fetchLetter (): Future[Letter] = Future {
    Thread.sleep(1000)
    Letter(Name.apply("Jake"), Postcode.apply("B20 3LL"))
  }

  val eventualLetter = fetchLetter()

  def checkError: String = eventualLetter.value match {
    case Some(Success(foundLetter)) => s"The future completed with a value $foundLetter"
    case Some(Failure(exception)) => s"The future completed with an exception: $exception"
    case None => "The future did not complete"
  }

  println(Await.ready(eventualLetter, 5.seconds))
  println(checkError)

}
