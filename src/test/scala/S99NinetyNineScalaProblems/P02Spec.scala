package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P02Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "penultimate" should "最後から2番目の要素を取得できる" in {
    assert(P02.penultimate(List(1, 1, 2, 3, 5, 8)) == 5)
  }
}
