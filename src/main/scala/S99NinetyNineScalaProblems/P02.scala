package S99NinetyNineScalaProblems

import scala.annotation.tailrec

// 最後から2番目の要素を取得する
object P02 {
  def penultimate(list: List[Int]): Int = {
    // 最初のn個の要素からなるリストを求め、その最後の要素を取得
    // list.take(list.length - 1).last

    // 指定した要素を取得(0始まり)
    list(list.length - 2)
  }

  // 解答
  @tailrec
  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h // Nilになにか(_のこと)を追加し、さらになにか(h)を追加している構造(List(_, h))。つまり要素が2つのリストの場合
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException
  }

  // 解答になぜかのってた。遊びで指定した場所の要素をとるやつ
  def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head // 後ろから引数個の要素のリストを作り、先頭をとる
  }

  // 上を再起でやるやつ
  def lastNthRecursive[A](n: Int, ls: List[A]): A = {


    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException //
        case Nil              => resultList.head // 先頭を返す。終了条件
        case _ :: tail        => //
          lastNthR(
            count - 1,
            if (count > 0) resultList else resultList.tail, // countがなくなったら先頭要素を削除
            tail
          )
      }

    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }
}