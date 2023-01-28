package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class コレクションSpec extends AnyFlatSpec with Diagrams with TimeLimits {
  "headで" should "先頭とれる" in {
    assert(コレクション.先頭(List(1, 2, 3)) === 1)
  }
  "tailで" should "先頭以外とれる" in {
    assert(コレクション.先頭以外(List(1, 2, 3)) === List(2, 3))
  }
  "isEmptyで" should "空判定" in {
    assert(コレクション.空判定(List()))
    assert(!コレクション.空判定(List(1, 2, 3)))
  }

  "lastで" should "末尾とれる" in {
    assert(コレクション.末尾(List(1, 2, 3)) === 3)
  }
  "initで" should "末尾以外とれる" in {
    assert(コレクション.末尾以外(List(1, 2, 3)) === List(1, 2))
  }

  "takeで" should "先頭からn個とれる" in {
    assert(コレクション.先頭からn個(List(1, 2, 3), 2) === List(1, 2))
  }
  "takeRightで" should "末尾からn個とれる" in {
    assert(コレクション.末尾からn個(List(1, 2, 3), 2) === List(2, 3))
  }
  "dropで" should "先頭からn個以外とれる" in {
    assert(コレクション.先頭からn個以外(List(1, 2, 3), 2) === List(3))
  }
  "dropRightで" should "末尾からn個以外とれる" in {
    assert(コレクション.末尾からn個以外(List(1, 2, 3), 2) === List(1))
  }

  "splitAtで" should "nの箇所で分割" in {
    assert(コレクション.nの箇所で分割(List(1, 2, 3), 2) === (List(1, 2), List(3)))
  }

  "lengthで" should "要素数とれる" in {
    assert(コレクション.listの長さ(List(1, 2, 3)) === 3)
  }

  "reverseで" should "逆順になる" in {
    assert(コレクション.逆順(List(1, 2, 3)) === List(3, 2, 1))
  }

  "applyで" should "要素を取る" in {
    assert(コレクション.要素の取得(List(1, 2, 3), 0) === 1)
    assert(コレクション.要素の取得(List(1, 2, 3), 1) === 2)
    assert(コレクション.要素の取得(List(1, 2, 3), 2) === 3)
    assert(コレクション.要素の取得2(List(1, 2, 3), 0) === 1)
    assert(コレクション.要素の取得2(List(1, 2, 3), 1) === 2)
    assert(コレクション.要素の取得2(List(1, 2, 3), 2) === 3)
  }

  "indicesで" should "indexのRangeがとれる" in {
    // エラーが出た時にassertの中で日本語の関数を呼び出しているとDiagramsがズレる問題は、部分関数をつかって丸ごと関数の名前だけ置き換えてしまえばおK
    val function = コレクション.有効なindexのRange取得 _

    val range: Range.Inclusive = 0 to 2
    assert(function(List(1, 2, 3)) === range)
  }

  "flattenで" should "ネストを解消" in {
    assert(コレクション.listを単層にする(List(List(1, 2), List(3, 4, 5))) === List(1, 2, 3, 4, 5))

    // List(List(1, 2), List(3, List(4,5)))みたいな2層ネストしているやつはList(1, 2, 3, List(4, 5))で返ってきちゃう
  }

  "zip演算で" should "mapみたいなやつに" in {
    assert(コレクション.zip演算(List(1, 2, 3), List(4, 5, 6)) === List((1, 4), (2, 5), (3, 6)))
    assert(コレクション.zip演算(List(1, 2, 3), List("a", "b", "c")) === List((1, "a"), (2, "b"), (3, "c")))
    // はみ出た部分は捨てられる
    assert(コレクション.zip演算(List(1, 2, 3), List("a", "b", "c", "d")) === List((1, "a"), (2, "b"), (3, "c")))
    assert(コレクション.zip演算(List(1, 2, 3, 4), List("a", "b", "c")) === List((1, "a"), (2, "b"), (3, "c")))
  }
  "zipWithIndexで" should "index付きのリストに" in {
    assert(コレクション.indexをつけたペアを作る(List(1, 2, 3)) === List((1, 0), (2, 1), (3, 2)))
  }
  "unzipで" should "ペアのリストを分割" in {
    assert(コレクション.タプル分解(List((1, 2), (3, 4), (5, 6))) === (List(1, 3, 5), List(2, 4, 6)))
  }

  "toStringとmkString" should "文字列表現に" in {
    assert(コレクション.文字列表現(List(1, 2, 3)) === "List(1, 2, 3)")
    assert(コレクション.文字列表現2(List(1, 2, 3)) === "List(1, 2, 3)")
    assert(コレクション.文字列表現3(List(1, 2, 3), ",") === "1,2,3")
    assert(コレクション.文字列表現4(List(1, 2, 3), "【", "■", "】") === "【1■2■3】")
  }

  "arrayに変換" should "できる" in {
    assert(コレクション.list_array変換(List(1, 2, 3)) === Array(1, 2, 3))
  }
  "listに変換" should "できる" in {
    assert(コレクション.array_list変換(Array(1, 2, 3)) === List(1, 2, 3))
  }

  "マージソート" should "ちゃんとソートできる" in {
    def stringの比較方法(x: String, y: String): Boolean = x < y
    assert(コレクション.msort(stringの比較方法)(List("a", "b", "c", "d", "e")) === List("a", "b", "c", "d", "e"))
    assert(コレクション.msort(stringの比較方法)(List("d", "b", "a", "e", "c")) === List("a", "b", "c", "d", "e"))

    def intの比較方法(x: Int, y: Int): Boolean = x < y
    val intの比較方法を第一級として使うこともできるぞ = intの比較方法 _

    // カリー化されてるので型パラメータをIntに限定したやつを作り出したり
    val int用のマージソート = コレクション.msort(intの比較方法を第一級として使うこともできるぞ) _
    assert(int用のマージソート(List(3, 2, 1)) === List(1, 2, 3))

    // もちろん全部の引数を渡してもOK
    val int用のマージソートにソート対象もつけちゃった = int用のマージソート(List(3, 2, 1, 10, 5, 6, 9, 8, 7, 4))
    assert(int用のマージソートにソート対象もつけちゃった === List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    // カリー化されていると別の用途の関数を新たにつくりだして、それに別名をつけられる
    def intの比較方法_逆順(x: Int, y: Int): Boolean = x > y
    val int用のマージソート_逆順 = コレクション.msort(intの比較方法_逆順) _
    assert(int用のマージソート_逆順(List(3, 2, 1, 10, 5, 6, 9, 8, 7, 4)) === List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
  }

  "mapで" should "List好き放題" in {
    assert(コレクション.mapでList全部操作(List(1, 2, 3)) === List(2, 3, 4))
    assert(コレクション.mapでList全部操作(コレクション.mapでList全部操作(List(1, 2, 3))) === List(3, 4, 5))
    assert(コレクション.mapでList全部操作(List()) === List())
  }
  "mapで" should "Option好き放題" in {
    assert(コレクション.mapでOptionの中触る(Some(1)) === Some(2))
    assert(コレクション.mapでOptionの中触る(None) === None)
  }

  "flatmapにListを渡すと" should "flattenしたListで返ってくる" in {
    assert(コレクション.flatMapで元の値とインクリメントした値(List(1, 2, 3)) === List(1, 2, 2, 3, 3, 4))
  }

  "flatmapにOptionを渡すと" should "Optionで返ってくる" in {
    assert(コレクション.flatMapでOption(Some(1)) === Some(2))
    assert(コレクション.flatMapでOption(None) === None)
  }

  "mapとflatMapをfor式で良い感じに" should "できる" in {
    assert(コレクション.mapとflatMapをfor式で良い感じに(Some(1)) === Some(3))
    assert(コレクション.mapとflatMapをfor式で良い感じに(None) === None)
  }


}
