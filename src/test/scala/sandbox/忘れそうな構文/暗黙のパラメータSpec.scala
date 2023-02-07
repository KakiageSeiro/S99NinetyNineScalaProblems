package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class 暗黙のパラメータSpec extends AnyFlatSpec with Diagrams with TimeLimits {
  "暗黙のパラメータを使って最大の要素を見つける" should "最大の要素を見つける" in {
    assert(暗黙のパラメータ.暗黙のパラメータを使って最大の要素を見つける(List(1,2,3,4,5)) === 5)
  }

  "暗黙のパラメータをimplicitlyで見つける" should "最大の要素を見つける" in {
    assert(暗黙のパラメータ.暗黙のパラメータをimplicitlyで見つける(List(1, 2, 3, 4, 5)) === 5)
  }

  "暗黙のパラメータをコンテキスト境界で表現" should "最大の要素を見つける" in {
    assert(暗黙のパラメータ.暗黙のパラメータをコンテキスト境界で表現(List(1, 2, 3, 4, 5)) === 5)
  }
}
