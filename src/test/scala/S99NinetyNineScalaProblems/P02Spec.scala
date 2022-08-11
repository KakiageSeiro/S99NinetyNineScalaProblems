package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P02Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "penultimate" should "最後から2番目の要素を取得できる" in {
    assert(P02.penultimate(List(1, 1, 2, 3, 5, 8)) == 5)
  }

  "penultimateRecursive" should "最後から2番目の要素を取得できる" in {
    assert(P02.penultimateRecursive(List(1, 1, 2, 3, 5, 8)) == 5)
  }

  "lastNthBuiltin" should "最後から2番目の要素を取得できる" in {
    assert(P02.lastNthBuiltin(2, List(1, 1, 2, 3, 5, 8)) == 5)
  }
  "lastNthBuiltin" should "最後から2番目の要素を取得できる(別の番号指定)" in {
    assert(P02.lastNthBuiltin(4, List(1, 1, 2, 3, 5, 8)) == 2)
  }
}
