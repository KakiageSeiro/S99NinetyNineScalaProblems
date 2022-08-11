package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P01Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "last関数" should "要素の最後が取得できる" in {
    assert(P01.last(List(1, 2, 3)) === 3)
  }

  "lastRecursive関数" should "要素の最後が取得できる" in {
    assert(P01.last(List(1, 2, 3)) === 3)
  }
  "lastRecursive関数" should "要素が無い場合Throw" in {
    intercept[NoSuchElementException] {
      P01.last(List())
    }
  }
}
