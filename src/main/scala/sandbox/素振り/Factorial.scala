package sandbox.素振り

import scala.annotation.tailrec

object Factorial {
  def forで階乗(target: Int): BigDecimal = {
    var result = BigDecimal(1)
    for (i <- 2 to target) {
      result *= i
    }

    result
  }

  // IntelliJだと関数定義の左側のデバッグポイント仕込めるところに渦巻きマークがでる。多分末尾再起ではない再起のこと。
  def 再起で階乗(かける値: Int): BigDecimal = かける値 match {
    case 1 => 1
    case _ => かける値 * 再起で階乗(かける値 - 1)
  }

  // IntelliJだと関数定義の左側のデバッグポイント仕込めるところにウロボロスマークがでる。多分末尾再起のこと。
  @tailrec
  def 再起で階乗_改(かける値: Int, 初期値: BigDecimal): BigDecimal = かける値 match {
    case 1 => 初期値
    case _ => 再起で階乗_改(かける値 - 1, 初期値 * かける値)
  }
}