package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class Stringでequals使わなくて良いぞ extends AnyFlatSpec with Diagrams with TimeLimits {
  "==で比較" should "値を比較している" in {
    val str1 = new String("abc")
    val str2 = new String("abc")
    assert(str1 == str2)
  }

  "eq(Javaのequalsみたいな)で比較" should "参照を比較している" in {
    val str1 = new String("abc")
    val str2 = new String("abc")
    assert(!(str1 eq str2)) // !のときには.や()まとめないとダメみたい
    assert(!str1.eq(str2))
    assert(str1 ne str2) // neはeqの否定
  }
}
