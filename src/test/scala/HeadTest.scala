package reinvent

import org.scalatest._
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalatest.prop.PropertyChecks

class HeadTest extends FunSuite with Matchers with PropertyChecks {

  test("Head should exist in the input") {
    forAll{ input: List[Int] =>
      whenever (input.nonEmpty) {
        input.contains(Head(input)) should be (true)
      }
    }
  }
}
