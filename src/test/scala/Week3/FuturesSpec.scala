package Week3

import Week3.Fri.Futures._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec

class FuturesSpec extends AnyWordSpec with Matchers with ScalaFutures {

  /** This is the most important variable when testing Future methods!!
   *  */
  implicit val defaultWaitTime: PatienceConfig = PatienceConfig(timeout = Span(3, Seconds), interval = Span(500, Millis))

  "additionMethod" should {
    "add two ints" in {
      addition(1, 2) shouldEqual 3
    }
  }

  /** Unit test for the future */
  "additionInTheFuture" should {
    "eventually return the current sum" in {
      whenReady(additionInTheFuture) {
        result => result shouldEqual 3
      }
    }
  }
}
