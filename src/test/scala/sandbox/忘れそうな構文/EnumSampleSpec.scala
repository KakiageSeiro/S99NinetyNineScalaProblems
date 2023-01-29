package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class EnumSampleSpec extends AnyFlatSpec with Diagrams with TimeLimits {
  "Enum" should "当然比較できる" in {
    assert(EnumSample.Red == EnumSample.Red)
    assert(EnumSample.Red != EnumSample.Green)
  }

  "Enum" should "文字列で取得" in {
    // forで列挙できる
    for (elem <- EnumSample.values) {
      // withNameで文字列から取得
      assert(EnumSample.withName(elem.toString) == elem)
    }
  }

  "Enum" should "index取得" in {
    assert(EnumSample.Red.id == 0)
    assert(EnumSample.Green.id == 1)
    assert(EnumSample.Blue.id == 2)
  }

  "Enum2" should "当然比較できる" in {
    assert(EnumSample2.Red2 == EnumSample2.Red2)
    assert(EnumSample2.Red2 != EnumSample2.Green2)
  }

  "Enum2" should "文字列で取得" in {
    // forで列挙できる
    for (elem <- EnumSample2.values) {
      // withNameで文字列から取得
      assert(EnumSample2.withName(elem.toString) == elem)
    }
  }


  "Enum2" should "日本語別名で定義したやつをとれる" in {
    assert(EnumSample2.Red2.getValue == "あか")
    assert(EnumSample2.Green2.getValue == "みどり")
    assert(EnumSample2.Blue2.getValue == "あお")
  }
}
