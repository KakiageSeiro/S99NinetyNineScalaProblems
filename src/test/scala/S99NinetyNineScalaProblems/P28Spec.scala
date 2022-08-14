package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P28Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "lsortFreq" should "要素数でソートされている" in {
    val before = List(
      List('a', 'b', 'c'),
      List('d', 'e'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('i', 'j', 'k', 'l'),
      List('m', 'n'),
      List('o')
    )
    val after = P28.lsort(before)

    // List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
    assert(after(0)(0) == 'o')
    assert(after(1)(0) == 'd')
    assert(after(1)(1) == 'e')
    assert(after(2)(0) == 'd')
    assert(after(2)(1) == 'e')
    assert(after(3)(0) == 'm')
    assert(after(3)(1) == 'n')
    assert(after(4)(0) == 'a')
    assert(after(4)(1) == 'b')
    assert(after(4)(2) == 'c')
    assert(after(5)(0) == 'f')
    assert(after(5)(1) == 'g')
    assert(after(5)(2) == 'h')
    assert(after(6)(0) == 'i')
    assert(after(6)(1) == 'j')
    assert(after(6)(2) == 'k')
    assert(after(6)(3) == 'l')
  }


}
