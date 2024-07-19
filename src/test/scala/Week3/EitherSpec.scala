package Week3

import Week3.Thurs.Either._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EitherSpec extends AnyWordSpec with Matchers {

  "isOdd" should {
    "return a Right" when {
      "the number is odd" in {
        val result = isOdd(3)
        result shouldBe Right("3 is odd")
      }
      "the number is odd and large" in {
        val result = isOdd(786903)
        result shouldBe Right("786903 is odd")

      }
    }

    "return a left" when {
      "the number is even" in {
        val result = isOdd(2)
        result shouldBe Left(IsOddError)
//        isOdd(4) shouldBe Left(IsOddError)
      }

    }
  }
}
