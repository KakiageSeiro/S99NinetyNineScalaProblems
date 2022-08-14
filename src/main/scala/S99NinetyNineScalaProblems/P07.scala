package S99NinetyNineScalaProblems

// ネストしたリストを単一リストにする
object P07 {
  // これだとIntを受け取れない
//  def flatten(list: List[Int] *): List[Int] = {
//    list.flatten.toList
//  }

  // そもそも単一のリストの中に、リストやIntが含まれている構造が問題の趣旨
  def flatten(list: List[Any]): List[Any] = {
    list.flatMap {
      // 標準である型をつかって型クラスとパターンマッチの組み合わせの方法をつかって、flatmapできる型(List)に変換してあげる
      case list: List[_] => flatten(list) // 普通のListの場合はflatten使えばいい
      case e => List(e) // IntがきちゃったらListで包む
    }
  }
}