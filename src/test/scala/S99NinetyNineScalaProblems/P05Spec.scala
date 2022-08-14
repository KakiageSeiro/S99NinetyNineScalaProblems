package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P05Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "length" should "逆転してる" in {
    val before = List(1, 1, 2, 3, 5, 8)
    val after = P05.reverse(before)

    assert(before(0) == after(5))
    assert(before(1) == after(4))
    assert(before(2) == after(3))
    assert(before(3) == after(2))
    assert(before(4) == after(1))
    assert(before(5) == after(0))
  }

  "reverseFunctional" should "逆転してる" in {
    val before = List(1, 1, 2, 3, 5, 8)
    val after = P05.reverseFunctional(before)

    assert(before(0) == after(5))
    assert(before(1) == after(4))
    assert(before(2) == after(3))
    assert(before(3) == after(2))
    assert(before(4) == after(1))
    assert(before(5) == after(0))
  }

}
