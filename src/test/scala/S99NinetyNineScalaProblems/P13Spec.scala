package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P13Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "runLength" should "連続した重複数が数字になってる" in {
    // 連続してない文字もListになってることに注意

    val before = List((2, 'a'), (1, 'b'), (1, 'c'))
    val after = P12.runLengthDecode(before)

    assert(after.length == 4)
    assert(after(0) == 'a')
    assert(after(1) == 'a')
    assert(after(2) == 'b')
    assert(after(3) == 'c')
  }

  "runLength" should "連続した重複数が数字になってる2" in {
    val before = List(
      (4, 'a'),
      (1, 'b'),
      (2, 'c'),
      (2, 'a'),
      (1, 'd'),
      (4, 'e'),
    )
    val after = P12.runLengthDecode(before)

    assert(after.length == 14)

    assert(after(0) == 'a')
    assert(after(1) == 'a')
    assert(after(2) == 'a')
    assert(after(3) == 'a')

    assert(after(4) == 'b')

    assert(after(5) == 'c')
    assert(after(6) == 'c')

    assert(after(7) == 'a')
    assert(after(8) == 'a')

    assert(after(9) == 'd')

    assert(after(10) == 'e')
    assert(after(11) == 'e')
    assert(after(12) == 'e')
    assert(after(13) == 'e')
  }
}
