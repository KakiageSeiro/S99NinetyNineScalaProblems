package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P10Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "runLength" should "連続した重複数が数字になってる" in {
    // 連続してない文字もListになってることに注意

    val before = List('a', 'a', 'b', 'c')
    val after = P10.runLength(before)

    assert(after.length == 3)
    assert(after(0) == (2, 'a'))
    assert(after(1) == (1, 'b'))
    assert(after(2) == (1, 'c'))
  }

  "runLength" should "連続した重複数が数字になってる2" in {
    val before = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val after = P10.runLength(before)

    assert(after.length == 6)
    assert(after(0) == (4, 'a'))
    assert(after(1) == (1, 'b'))
    assert(after(2) == (2, 'c'))
    assert(after(3) == (2, 'a'))
    assert(after(4) == (1, 'd'))
    assert(after(5) == (4, 'e'))
  }


}
