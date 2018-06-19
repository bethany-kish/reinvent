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

  test("Head should be first element of input"){
    forAll{ input: List[Int] =>
      whenever (input.nonEmpty){
        input(0) == Head(input) should be (true)
      }
    }
  }

}

class FilterTest extends FunSuite with Matchers with PropertyChecks {

  test("Filter should return a list smaller or equal in size to the input") {
    forAll { (input: List[Int], pred: Boolean) => {
      Filter(input, { X: Int => pred }).size <= input.size} should be(true)
    }
  }


  test("Filter should return the input if the predicate is always true") {
    forAll { input: List[Int] =>
      Filter(input, { X: Int => true }) should be(input)
    }
  }

  test("Filter should return an empty list if the predicate is always false") {
    forAll { input: List[Int] =>
      Filter(input, { X: Int => false }) should be(Nil)
    }
  }
}

