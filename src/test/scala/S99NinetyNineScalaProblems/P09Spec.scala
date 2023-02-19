package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P09Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "pack" should "連続した重複がListになってる" in {
    // 連続してない文字もListになってることに注意

    val before = List('a', 'a', 'b', 'c')
    val after = P09.pack(before)

    assert(after.length == 3)
    assert(after(0) == List('a', 'a'))
    assert(after(1) == List('b'))
    assert(after(2) == List('c'))
  }

  "pack" should "連続した重複がListになってる2" in {
    val before = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val after = P09.pack(before)

    assert(after.length == 6)
    assert(after(0) == List('a', 'a', 'a', 'a'))
    assert(after(1) == List('b'))
    assert(after(2) == List('c', 'c'))
    assert(after(3) == List('a', 'a'))
    assert(after(4) == List('d'))
    assert(after(5) == List('e', 'e', 'e', 'e'))
  }


}
