package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P02Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "penultimate" should "最後から2番目の要素を取得できる" in {
    assert(P02.penultimate(List(1, 1, 2, 3, 5, 8)) == 5)
  }

  "penultimateRecursive" should "最後から2番目の要素を取得できる" in {
    assert(P02.penultimateRecursive(List(1, 1, 2, 3, 5, 8)) == 5)
  }

  "lastNthBuiltin" should "最後から2番目の要素を取得できる" in {
    assert(P02.lastNthBuiltin(2, List(1, 1, 2, 3, 5, 8)) == 5)
  }
  "lastNthBuiltin" should "最後から2番目の要素を取得できる(別の番号指定)" in {
    assert(P02.lastNthBuiltin(4, List(1, 1, 2, 3, 5, 8)) == 2)
  }

  "lastNthRecursive" should "最後から2番目の要素を取得できる" in {
    assert(P02.lastNthRecursive(2, List(1, 1, 2, 3, 5, 8)) == 5)
    // 呼び出し回数と変数の状態
    //  2, resultList(1, 1, 2, 3, 5, 8)curList(1, 1, 2, 3, 5, 8)
    //  1, resultList(1, 1, 2, 3, 5, 8)curList(1, 2, 3, 5, 8)
    //  0, resultList(1, 1, 2, 3, 5, 8)curList(2, 3, 5, 8)
    // ここまででcountの数curから要素がなくなっている状態
    // curの要素数が、resultの先頭から削除したい要素数となっている
    // つまり、元の要素数-最後からn番目を削除したい=先頭から削除すればよい要素数 をやっている
    // なんでこんな面倒くさいことをやってるんだろう。再起のサンプルだから？
    // -1, resultList(1, 2, 3, 5, 8)curList(3, 5, 8)
    // -2, resultList(2, 3, 5, 8)curList(5, 8)
    // -3, resultList(3, 5, 8)curList(8)
    // -4, resultList(5, 8)curList()

  }
  "lastNthRecursive" should "最後から2番目の要素を取得できる(別の番号指定)" in {
    assert(P02.lastNthRecursive(4, List(1, 1, 2, 3, 5, 8)) == 2)
  }

}
