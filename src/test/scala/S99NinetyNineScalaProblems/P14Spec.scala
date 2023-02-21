package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P14Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "duplicate" should "2個になってる" in {
    val before = List('a', 'b', 'c', 'c', 'd')
    val after = P14.duplicate(before)

    assert(after.length == 10)
    assert(after(0) == 'a')
    assert(after(1) == 'a')
    assert(after(2) == 'b')
    assert(after(3) == 'b')
    assert(after(4) == 'c')
    assert(after(5) == 'c')
    assert(after(6) == 'c')
    assert(after(7) == 'c')
    assert(after(8) == 'd')
    assert(after(9) == 'd')
  }
}
