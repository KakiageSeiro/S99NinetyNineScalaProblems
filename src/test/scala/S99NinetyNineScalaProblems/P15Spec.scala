package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P15Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "duplicateN" should "指定回数分増えている" in {
    val before = List('a', 'b', 'c', 'c', 'd')
    val after = P15.duplicateN(3, before)

    assert(after.length == 15)
    assert(after(0) == 'a')
    assert(after(1) == 'a')
    assert(after(2) == 'a')
    assert(after(3) == 'b')
    assert(after(4) == 'b')
    assert(after(5) == 'b')
    assert(after(6) == 'c')
    assert(after(7) == 'c')
    assert(after(8) == 'c')
    assert(after(9) == 'c')
    assert(after(10) == 'c')
    assert(after(11) == 'c')
    assert(after(12) == 'd')
    assert(after(13) == 'd')
    assert(after(14) == 'd')
  }


}
