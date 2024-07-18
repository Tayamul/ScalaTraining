package Week3

import Week3.Thurs.ForComp._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ForCompSpec extends AnyWordSpec with Matchers {

  "retrieveNumbers" should {

    val expected = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    "generate a sequence of numbers from 1 to 10" in {
      retrieveNumbers shouldBe expected
    }

    "contain 10 elements" in {
      retrieveNumbers should have length 10
    }

    "should start with 1 and end with 10" in {
      retrieveNumbers.head shouldBe 1
      retrieveNumbers.last shouldBe 10
    }
  }
}
