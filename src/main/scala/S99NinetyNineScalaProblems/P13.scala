package S99NinetyNineScalaProblems

object P13 {
  // 問題が何を言ってるかよくわからなかったので解答をコピペ
  // いままでの知識を踏まえて良い感じに作り直してねってことだったっぽい

  // S99本家の解答
  def encodeDirect[A](ls: List[A]): List[(Int, A)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span { // spanは条件を満たす前後を分離するやつ
        _ == ls.head // 同じ文字が続いている間をpackedに、それ以降をnextに
      }
      (packed.length, packed.head) :: encodeDirect(next) // これを繰り返す
    }

  // ドワンゴの解答
  // https://github.com/dwango/S99/blob/master/src/main/scala/jp/co/dwango/s99/P13.scala
  def dwangoEncodeDirect[T](list: List[T]): List[(Int, T)] = {
    def encodeDirect1(pre: T, n: Int, rest: List[T]): List[(Int, T)] = {
      rest match {
        case x :: xs if pre == x => encodeDirect1(pre, n + 1, xs) // ifで先頭文字と同じ文字であるか判定して、同じ場合はnをインクリメント
        case x :: xs => (n, pre) :: encodeDirect1(x, 1, xs) // 違う文字がきたらタプルをつくって次の文字の数を数えるフェーズに入る
        case _ => List((n, pre)) // 最後の文字の場合はタプルをつくって終了
      }
    }

    list match {
      case x :: xs => encodeDirect1(x, 1, xs)
      case _ => List()
    }
  }
}