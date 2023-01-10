package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec
import sandbox.忘れそうな構文.クラスの引数とフィールド両方一気に定義.{一気に定義, 一気に定義2}

class 一気に定義Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "クラスの引数とフィールド両方一気に定義" should "フィールドをとれる" in {
    val 一気に定義 = new 一気に定義("abc")
    assert(一気に定義.とるだけ === "abc")
  }

  "privateになってると" should "フィールドをとれない" in {
    val 一気に定義2 = new 一気に定義2("abc")
    // assert(一気に定義2.とるだけ === "abc") これは出来ない
  }
}
