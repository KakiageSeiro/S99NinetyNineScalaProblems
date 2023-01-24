package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P04Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "length" should "要素数を取得できる" in {
    assert(P04.length(List(1, 1, 2, 3, 5, 8)) == 6)
  }

  "tatamikomi" should "要素数を取得できる" in {
    assert(P04.tatamikomi(List(1, 1, 2, 3, 5, 8)) == 6)
  }

  "tatamikomi2" should "reduceでも要素数を取得できる" in {
    assert(P04.tatamikomi2(List(1, 1, 2, 3, 5, 8)) == 6)
  }

}
