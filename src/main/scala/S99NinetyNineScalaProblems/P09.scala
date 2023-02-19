package S99NinetyNineScalaProblems

object P09 {
  // https://github.com/dwango/S99/blob/master/src/main/scala/jp/co/dwango/s99/P09.scala
  def pack[T](list: List[T]): List[List[T]] =
    list.foldRight(Nil: List[List[T]]) { (e, ls) =>
      ls match {
        // e(左)と同じ文字の子リストだったら、文字を追加(e(左)を先頭に追加)
        case (x@`e` :: _) :: xs => (e :: x) :: xs
        // e(左)と同じ文字のリストがなかったら、新しいリストを作って親リストに追加
        case _ => List(e) :: ls
      }
    }

  // この実装は
  // ・親リストをlsとし、これがNilからスタートすること。
  // ・(x@`e` :: _) :: xsの
  //   (x@`e` :: _)部分が直前で追加した文字(先頭の子リスト)であること※①
  // ・foldRightなのは、親リストの先頭に追加するため(多分パフォーマンス)
  // を理解すると意味が理解できる。
  //
  // たとえばList('a', 'a', 'b', 'c')の時
  // 最初はe='b',ls=List(List('c'))なので、List(List('b'), List('c'))になる
  // 次はe='a',ls=List(List('b'), List('c'))なので、
  //   先頭の子リストの中の、先頭要素である'b'と比較しマッチしないので、List(List('a', 'a'), List('b'), List('c'))になる
  // 次はe='a',ls=List(List('a', 'a'), List('b'), List('c'))なので、
  //   先頭の子リストの中の、先頭要素である'a'と比較しマッチするので、List(List('a', 'a'), List('b'), List('c'))になる
}