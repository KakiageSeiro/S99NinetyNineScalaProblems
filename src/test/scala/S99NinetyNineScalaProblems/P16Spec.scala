package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P16Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "drop" should "nの倍数の要素が消える" in {
    val before = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    val after = P16.drop(3, before)

    assert(after.length == 8)
    assert(after(0) == 'a')
    assert(after(1) == 'b')
    assert(after(2) == 'd')
    assert(after(3) == 'e')
    assert(after(4) == 'g')
    assert(after(5) == 'h')
    assert(after(6) == 'j')
    assert(after(7) == 'k')
  }


}
