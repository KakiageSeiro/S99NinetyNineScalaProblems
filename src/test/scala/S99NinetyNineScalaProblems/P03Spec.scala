package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P03Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "nth" should "n番目の要素を取得できる" in {
    assert(P03.nth(2, List(1, 1, 2, 3, 5, 8)) == 2)
  }
}
