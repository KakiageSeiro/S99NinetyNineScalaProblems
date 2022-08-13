package S99NinetyNineScalaProblems

// 指定したindexの要素を取得する
object P03 {
  def nth(n: Int, list: List[Int]): Int = {
    list(n)
  }

  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h // 終了条件。hには最初の要素が入る？
    case (n, _ :: tail) => nthRecursive(n - 1, tail) // 再起
    case (_, Nil      ) => throw new NoSuchElementException // このcaseはガード節のように先頭に書いたほうがよいのでは？
  }
}