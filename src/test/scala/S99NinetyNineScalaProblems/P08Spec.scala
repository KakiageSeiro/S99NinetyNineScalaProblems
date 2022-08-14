package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P08Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "compress" should "連続した重複が消えてる" in {
    val before = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val after = P08.compress(before)

    assert(after.length == 6)
    assert(after(0) == 'a')
    assert(after(1) == 'b')
    assert(after(2) == 'c')
    assert(after(3) == 'a')
    assert(after(4) == 'd')
    assert(after(5) == 'e')
  }


}
