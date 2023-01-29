package sandbox.忘れそうな構文

import javax.management.Query.value

object EnumSample extends Enumeration { // ■Enumerationを継承するよ■
  val Red, Green, Blue = Value // =Valueが必要
}

object EnumSample2 extends Enumeration {
  val Red2 = value("あか")
  val Green2 = value("みどり")
  val Blue2 = value("あお")
}