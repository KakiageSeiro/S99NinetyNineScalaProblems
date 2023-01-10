package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class パラメータ無しメソッドSpec extends AnyFlatSpec with Diagrams with TimeLimits {
  "パラメータ無しメソッド" should "パラメータ無しフィールド" in {
    // とるだけメソッドが括弧無しで呼べる。単なるゲッターだけにしたほうが文化的によさそう
    assert(パラメータ無しメソッド.とるだけ === "abc")
  }
}
