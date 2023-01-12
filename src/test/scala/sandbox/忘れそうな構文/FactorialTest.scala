package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class Nothingつかう extends AnyFlatSpec with Diagrams with TimeLimits {
  "Nothing" should "メソッドがリターンしないかわりに例外を投げる" in {

    def 例外を投げるメソッド(): Nothingつかう = throw new Exception("例外を投げるメソッドだよ")
    assertThrows[Exception](例外を投げるメソッド()) // これは成功
    // ↓は"not found: value Nothingつかう"といわれる。なーーーぜーーーー？
    // assertThrows[Exception](Nothingつかう.エラーになるよ())

    // 以下の書き方でエラーの中も検証できる
    val exception = intercept[Exception] {
      例外を投げるメソッド()
    }
    assert(exception.getMessage === "例外を投げるメソッドだよ")

    // これをやりたかった…
    //    val exception = intercept[Exception] {
    //      Nothing.エラーになるよ()
    //    }
    //    assert(exception.getMessage === "エラーだよ")
  }
}
