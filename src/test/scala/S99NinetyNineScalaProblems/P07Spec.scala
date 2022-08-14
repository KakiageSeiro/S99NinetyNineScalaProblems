package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P07Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "flatten" should "一つのリストになってる" in {
    val before1 = List(1, 2, 3)
    val before2 = List(4, 5, 6)
    val after = P07.flatten(List(before1, before2))

    assert(before1(0) == after(0))
    assert(before1(1) == after(1))
    assert(before1(2) == after(2))
    assert(before2(0) == after(3))
    assert(before2(1) == after(4))
    assert(before2(2) == after(5))
  }
  "flatten" should "List以外の型が混じってても一つのリストになってる" in {
    val before1 = List(1, 2, 3)
    val before2 = List(4, 5, 6)
    val before3 = 7
    val after = P07.flatten(List(before1, before2, before3))

    assert(before1(0) == after(0))
    assert(before1(1) == after(1))
    assert(before1(2) == after(2))
    assert(before2(0) == after(3))
    assert(before2(1) == after(4))
    assert(before2(2) == after(5))
    assert(before3 == after(6))
  }


}
