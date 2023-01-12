package sandbox.素振り

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class FactorialTest extends AnyFlatSpec with Diagrams with TimeLimits {
  "forで1の階乗は" should "1になる" in {
    assert(Factorial.forで階乗(1) == 1)
  }

  "forで2の階乗は" should "2になる" in {
    assert(Factorial.forで階乗(2) == 2)
  }

  "forで3の階乗は" should "6になる" in {
    assert(Factorial.forで階乗(3) == 6)
  }

  "forで4の階乗は" should "24になる" in {
    assert(Factorial.forで階乗(4) == 24)
  }

  "forで14の階乗は" should "24になる" in {
    assert(Factorial.forで階乗(14) == BigDecimal("87178291200"))
  }

  "forで25の階乗は" should "15511210043330985984000000になる" in {
    assert(Factorial.forで階乗(25) == BigDecimal("15511210043330985984000000"))
  }

  "forで26の階乗は" should "-1569523520172457984でオーバーフロー" in {
    assert(Factorial.forで階乗(26) == BigDecimal("403291461126605635584000000"))
  }

  "forで10000の階乗は" should "桁数やばいけどこけない" in {
    assert(Factorial.forで階乗(10000) == BigDecimal("2.846259680917054518906413212119839E+35659"))
  }

  "forで50000の階乗は" should "桁数やばいけどこけない" in {
    assert(Factorial.forで階乗(50000) == BigDecimal("3.347320509597144836915476094071426E+213236"))
  }


  // ここから再起■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  "再起で1の階乗は" should "1になる" in {
    assert(Factorial.再起で階乗(1) == 1)
  }

  "再起で2の階乗は" should "2になる" in {
    assert(Factorial.再起で階乗(2) == 2)
  }

  "再起で3の階乗は" should "6になる" in {
    assert(Factorial.再起で階乗(3) == 6)
  }

  "再起で4の階乗は" should "24になる" in {
    assert(Factorial.再起で階乗(4) == 24)
  }

  "再起で25の階乗は" should "15511210043330985984000000になる" in {
    assert(Factorial.再起で階乗(25) == BigDecimal("15511210043330985984000000"))
  }

  "再起で26の階乗は" should "403291461126605635584000000になる" in {
    assert(Factorial.再起で階乗(26) == BigDecimal("403291461126605635584000000"))
  }

  "再起で10000の階乗は" should "スタックオーバーフロー" in {
    intercept[StackOverflowError] {
      Factorial.再起で階乗(10000)
    }
  }


  // ここから末尾再起■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  "末尾再起で1の階乗は" should "1になる" in {
    assert(Factorial.再起で階乗_改(1, 1) == BigDecimal("1"))
  }

  "末尾再起で2の階乗は" should "2になる" in {
    assert(Factorial.再起で階乗_改(2, 1) == BigDecimal("2"))
  }

  "末尾再起で3の階乗は" should "6になる" in {
    assert(Factorial.再起で階乗_改(3, 1) == BigDecimal("6"))
  }

  "末尾再起で4の階乗は" should "24になる" in {
    assert(Factorial.再起で階乗_改(4, 1) == BigDecimal("24"))
  }

  "末尾再起で25の階乗は" should "15511210043330985984000000になる" in {
    assert(Factorial.再起で階乗_改(25, 1) == BigDecimal("15511210043330985984000000"))
  }

  "末尾再起で26の階乗は" should "403291461126605635584000000になる" in {
    assert(Factorial.再起で階乗_改(26, 1) == BigDecimal("403291461126605635584000000"))
  }

  "末尾再起で10000の階乗は" should "桁数やばいけどこけない" in {
    assert(Factorial.再起で階乗_改(10000, 1) == BigDecimal("2.846259680917054518906413212119820E+35659"))
  }

  "末尾再起で50000の階乗は" should "桁数やばいけどこけない" in {
    assert(Factorial.再起で階乗_改(50000, 1) == BigDecimal("3.347320509597144836915476094071474E+213236"))
  }
}
