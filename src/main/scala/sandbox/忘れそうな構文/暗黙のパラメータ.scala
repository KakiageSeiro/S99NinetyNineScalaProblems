package sandbox.忘れそうな構文

object 暗黙のパラメータ {
  // Ordering[T]はlistの方のTがわかった時点で推論できる。テストではIntを渡してるので、IntのOrderingがどこかでimplicitとして定義されてるはず。
  def 暗黙のパラメータを使って最大の要素を見つける[T](list: List[T])(implicit ordering: Ordering[T]): T = list match {
    case Nil => throw new IllegalArgumentException("空！！！")
    case List(x) => x
    case head :: tail => {
      val max = 暗黙のパラメータを使って最大の要素を見つける(tail) // 暗黙のorderingが引数として追加されてる
      if (ordering.gt(head, max)) head
      else max
    }
  }

  def 暗黙のパラメータをimplicitlyで見つける[T](list: List[T])(implicit ordering: Ordering[T]): T = list match {
    case Nil => throw new IllegalArgumentException("空！！！")
    case List(x) => x
    case head :: tail => {
      val max = 暗黙のパラメータを使って最大の要素を見つける(tail)
      if (implicitly[Ordering[T]].gt(head, max)) head // implicitlyで暗黙のorderingを見つける。
      else max
    }
  }

  // 第二引数がなくなった。[T: Ordering]でTの型パラメータを取ることと、Ordering[T]の暗黙のパラメータを取ることの二役をやる
  // [T<: Ordering]という書き方でなにが変わるのかはよくわからない。[T: Ordering]のほうが柔軟みたい。Tに関係ないことをやってもいいのかも？例題がこの説明をするのに適してないかも。未実装なのでとりあえずTrueをかえすOrderingを渡しとくとか？
  def 暗黙のパラメータをコンテキスト境界で表現[T: Ordering](list: List[T]): T = list match {
    case Nil => throw new IllegalArgumentException("空！！！")
    case List(x) => x
    case head :: tail => {
      val max = 暗黙のパラメータを使って最大の要素を見つける(tail)
      if (implicitly[Ordering[T]].gt(head, max)) head // implicitlyで暗黙のorderingを見つける。
      else max
    }
  }

}