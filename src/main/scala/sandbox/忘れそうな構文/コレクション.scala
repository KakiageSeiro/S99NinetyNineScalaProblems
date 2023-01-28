package sandbox.忘れそうな構文

import scala.reflect.ClassTag

object コレクション {
  // O(1)
  def 先頭[T](list: List[T]): T = list.head

  def 先頭以外[T](list: List[T]): List[T] = list.tail

  def 空判定[T](list: List[T]): Boolean = list.isEmpty

  // O(n)
  def 末尾[T](list: List[T]): T = list.last

  def 末尾以外[T](list: List[T]): List[T] = list.init

  // 実装見てないけどたぶんO(n)
  def 先頭からn個[T](list: List[T], n: Int): List[T] = list.take(n)

  def 末尾からn個[T](list: List[T], n: Int): List[T] = list.takeRight(n)

  def 先頭からn個以外[T](list: List[T], n: Int): List[T] = list.drop(n)

  def 末尾からn個以外[T](list: List[T], n: Int): List[T] = list.dropRight(n)

  // takeとdropの組み合わせ。だけど実際にtakeとdropしているわけではない
  // O(n)。n部分までループしつつListの先頭を削っていき、残ったListのtailを返すので2回ループしないようになってる。
  def nの箇所で分割[T](list: List[T], n: Int): (List[T], List[T]) = list.splitAt(n)

  // O(n)。空であることを判定したい場合はisEmptyの方が良い。空のListはNilで、isEmptyはNilとの比較のみをしてる。
  def listの長さ[T](list: List[T]): Int = list.length

  // O(n)
  def 逆順[T](list: List[T]): List[T] = list.reverse

  // O(n)
  def 要素の取得[T](list: List[T], i: Int): T = list.apply(i)

  def 要素の取得2[T](list: List[T], i: Int): T = list(i)

  def 有効なindexのRange取得[T](list: List[T]): Range = list.indices

  // 単層っていう単語あるんだ
  // List[List[T]]を引数にしているが、要素がListとそれ以外が混じっているとコンパイルエラーになるので注意
  def listを単層にする[T](list: List[List[T]]): List[T] = list.flatten

  // 2つのリストを1つのペアのリストにする。拡張子のzipというより服のジッパー(チャック)のzipみたい。ギザギザイメージとのこと。
  def zip演算[T, U](list1: List[T], list2: List[U]): List[(T, U)] = list1.zip(list2)

  def indexをつけたペアを作る[T](list: List[T]): List[(T, Int)] = list.zipWithIndex

  def タプル分解[T, U](list: List[(T, U)]): (List[T], List[U]) = list.unzip

  def 文字列表現[T](list: List[T]): String = list.toString

  def 文字列表現2[T](list: List[T]): String = list.toString

  def 文字列表現3[T](list: List[T], セパレータ: String): String = list.mkString(セパレータ)

  def 文字列表現4[T](list: List[T], プレフィックス: String, セパレータ: String, サフィックス: String): String = list.mkString(プレフィックス, セパレータ, サフィックス)

  // No ClassTag available for Intというコンパイルエラーが出る。
  // 型消去されてしまうのでこちらのobject内部ではTがどの型なのかわからない。Javaの配列はメモリ上に型を考慮したデータ領域を確保するのでnewする時に型がわからないとダメ。
  // なので型パラメータに:ClassTagを付ける。これで型消去で消える情報を保持しておくみたい。
  // リフレクションなので使うと時は慎重に
  // https://ym.hatenadiary.jp/entry/2015/04/09/121621
  def list_array変換[T: ClassTag](list: List[T]): Array[T] = list.toArray

  def array_list変換[T](array: Array[T]): List[T] = array.toList

  // マージソート(コップ本でListの章なのに突如出現したマージソートの例を写経したやつ)
  def msort[T](is第一引数の方が少ない: (T, T) => Boolean)(list: List[T]): List[T] = {
    def merge(左: List[T], 右: List[T]): List[T] = (左, 右) match {
      case (Nil, _) => 右
      case (_, Nil) => 左
      case (x先頭 :: x先頭以外, y先頭 :: y先頭以外) =>
        // ここで並べ替えをする
        if (is第一引数の方が少ない(x先頭, y先頭)) x先頭 :: merge(x先頭以外, 右)
        else y先頭 :: merge(左, y先頭以外)
    }

    val n = list.length / 2
    if (n == 0) list
    else {
      val (left, right) = list splitAt n // 真ん中で分割
      merge(msort(is第一引数の方が少ない)(left), msort(is第一引数の方が少ない)(right))
    }
  }

  // mapとflatMapの違い(https://dev.classmethod.jp/articles/scala-learn-flatmap/)
  def mapでList全部操作(list: List[Int]): List[Int] = {
    def ふつうの値を引数にとって_ふつうの値を返す関数(i: Int): Int = i + 1

    list.map(ふつうの値を引数にとって_ふつうの値を返す関数)
  }

  def mapでOptionの中触る(optionalInt: Option[Int]): Option[Int] = {
    def ふつうの値を引数にとり_ふつうの値を返す関数(i: Int): Int = i + 1

    optionalInt.map(ふつうの値を引数にとり_ふつうの値を返す関数)
  }

  def flatMapで元の値とインクリメントした値(list: List[Int]): List[Int] = {
    def ふつうの値を引数にとり_文脈付きの値を返す関数(i: Int): List[Int] =
      List(i, i + 1) // ここが文脈付き。これを適用したいときにflatMapを使う

    list.flatMap(ふつうの値を引数にとり_文脈付きの値を返す関数)
  }

  def flatMapでOption(optionalInt: Option[Int]): Option[Int] = {
    def ふつうの値を引数にとり_文脈付きの値を返す関数(i: Int): Option[Int] =
      Option(i + 1) // ここが文脈付き。これを適用したいときにflatMapを使う
    optionalInt.flatMap(ふつうの値を引数にとり_文脈付きの値を返す関数)
  }

  // mapとflatMapを複雑に組み合わせる時はfor式を使うとよい
  def mapとflatMapをfor式で良い感じに(optionalInt: Option[Int]): Option[Int] = {
    def map向け(i: Int): Int = i + 1
    def flatMap向け(i: Int): Option[Int] = Option(i + 1)
    for {
      i <- optionalInt // 文脈を外す
      j = map向け(i)
      k <- flatMap向け(j)
    } yield k // 文脈(Option[Int])が保たれる
  }


}