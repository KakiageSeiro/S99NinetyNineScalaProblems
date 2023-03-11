package sandbox.忘れそうな構文

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
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

  // タプル(2,1)(3,1)(3,2)(4,1)(4,2)(4,3)を作る
  // (1,1)(2,1)(2,2)(3,1)(3,2)(3,3)(4,1)(4,2)(4,3)(4,4)になりそうに見えるが、Rangeは基本Inclusive(末尾を含まない)感じなのでmapレシーバーの最初は(1,1)は何もしない。(1,2)のときはj=1だけやる。(1,3)のときはj=1,2だけやる
  def flatMapでタプル作る(): List[(Int, Int)] = {
    List.range(1, 5).flatMap( // flatMapはInt(ふつうの値)を引数にとってList(文脈付きの値)を返す。レシーバーはList(文脈付き)
      i => List.range(1, i) map (j => (i, j)) // mapはInt(ふつうの値)を引数にとってタプル(ふつうの値なのか？)を返す。レシーバーはList(文脈付き)
    )
  }

  // ↑の糖衣構文。CROSS JOINみたいな感じと思うと良いかも
  def for式でタプル作る(): List[(Int, Int)] = {
    for {
      i <- List.range(1, 5)
      j <- List.range(1, i)
    } yield (i, j)
  }



  def filterで絞る(list: List[Int]): List[Int] = {
    list.filter(_ % 2 == 0)
  }

  // 中間リストをつくらないみたい。
  def withFilterで絞る(list: List[Int]): List[Int] = {
    list.withFilter(_ % 2 == 0).map(_ * 3)
  }

  def partitionで絞った結果と絞らなかった結果をタプルで返す(list: List[Int]): (List[Int], List[Int]) = {
    list.partition(_ % 2 == 0)
  }

  def findで最初に見つかった要素を返す(list: List[Int]): Option[Int] = {
    list.find(_ % 2 == 0)
  }

  def takeWhileで先頭から条件満たさない要素までを取る(list: List[Int]): List[Int] = {
    list.takeWhile(_ < 3)
  }

  def dropWhileで先頭から条件満たさない要素までを捨てる(list: List[Int]): List[Int] = {
    list.dropWhile(_ < 3)
  }

  // splitAtの時と同じくO(n)とのこと
  def spanでtakeWhileの結果とdropWhileの結果をタプルで返す(list: List[Int]): (List[Int], List[Int]) = {
    list.span(_ < 3)
  }

  def forallで全ての要素が条件を満たすか(list: List[Int]): Boolean = {
    list.forall(_ < 3)
  }

  def existsで少なくとも1つの要素が条件を満たすか(list: List[Int]): Boolean = {
    list.exists(_ < 3)
  }

  // 畳み込み
  def foldLeftで畳み込み(list: List[Int]): Int = {
    // P04問題のところに詳細書いたのでそっち見たほうが良い
    list.foldLeft(0)(_ + _)
  }

  def foldLeftを記号で(list: List[Int]): Int = {
    // scalaVersion := "2.13.8"では非推奨になってるけど面白い形なので残しておく
    list./:(0)(_ + _)
  }

  def foldRightで畳み込み(list: List[Int]): Int = {
    list.foldRight(0)(_ + _)
  }

  def foldRightを記号で(list: List[Int]): Int = {
    // scalaVersion := "2.13.8"では非推奨になってるけど面白い形なので残しておく
    list.:\(0)(_ + _)
  }

  // foldRightどこで使うの問題
  def foldRightで効率の良いListのflatten[T](list: List[List[T]]): List[T] = {
    list.foldRight(List[T]())(_ ::: _)
    // (_ ::: _)は左のサイズをnとして、左の末尾までたどりその後ろに結合するのでO(n)かかる。
    // foldRightは最初の計算で初期値(第一引数)ではなく、レシーバーの最初の要素が左になる。
    // 次の計算では、前の計算結果ではなく、レシーバーの次の要素が左になる。
    // このように、foldRightは常にレシーバーの要素の数が計算量になる。
    // foldLeftは現在時点までで足し合わせた結果の要素数が計算量になる。
    //
    // 例:子要素の数は全部1のList(List("a"), List("b"), List("c"), List("d"))をレシーバーとしたとき
    // foldLeft最初の計算(初期値 ::: a)なのでO(1)
    // foldLeft2回目(初期値+a ::: b)なのでO(1+a) // aは要素数1のListなのでO(2)
    // foldLeft3回目(初期値+a+b ::: c)なのでO(1+a+b) // aもbも要素数1のListなのでO(3)
    // foldLeft4回目(初期値+a+b+c ::: d)なのでO(1+a+b+c) // aもbもcも要素数1のListなのでO(4)
    // このように、計算回数を経るごとに計算量が要素数分増大していく。
    //
    // foldRight最初の計算(a ::: 初期値)なのでO(1) // aは要素数1のListなのでO(1)
    // foldRight2回目(b ::: 初期値+a)なのでO(1) // bは要素数1のListなのでO(1)
    // foldRight3回目(c ::: 初期値+a+b)なのでO(1) // cは要素数1のListなのでO(1)
    // foldRight4回目(d ::: 初期値+a+b+c)なのでO(1) // dは要素数1のListなのでO(1)
    // このように、常に要素数が少ない可能性が高い初期値を右に置くことで、計算量を減らすことができる。
    // 一応例外としてList(List("a"), List("b","b","b"), List("c","c","c","c","c","c","c","c")のように足し合わせた結果より大きい要素数Listが後続に続く場合もある。
  }

  def scanListでアキュームレータだす(list: List[Int]): List[Int] = {
    // 累積和かんたん！
    list.scanLeft(0)(_ + _)
  }

  def scanRightでアキュームレータだす(list: List[Int]): List[Int] = {
    // 計算途中の結果を出してくれる。つまり計算途中のaccumulatorの値を出してくれる。
    list.scanRight(0)(_ + _)
  }

  def reduceLeftで畳み込み(list: List[Int]): Int = {
    // foldLeftと同じく畳み込みだが、初期値がないので、最初の要素が初期値になる。(最初の要素を2回つかうわけではない)
    list.reduceLeft(_ + _)
  }

  def reduceRightで畳み込み[T](list: List[List[T]]): List[T] = {
    list.reduceRight(_ ::: _)
  }

  def sortWithでソート(list: List[Int]): List[Int] = {
    list.sortWith(_ < _) // 昇順
  }

  def fillで同じ値のListを作る(size: Int, 値: String): List[String] = {
    List.fill(size)(値)
  }

  def fillで同じ値のListを複数作る(Listの要素数: Int, 値: String, Listの数: Int): List[List[String]] = {
    List.fill(Listの数, Listの要素数)(値)
  }

  def tabulateで関数計算結果のListを作る(size: Int, f: Int => Int): List[Int] = {
    List.tabulate(size)(f)
  }

  // for式で2つのListをとってyieldに_ * _を入れた感じに似てる
  def tabulateで関数計算結果の複数Listを作る(Listの要素数: Int, Listの数: Int): List[List[Int]] = {
    List.tabulate(Listの数, Listの要素数)(_ * _)
  }

  // :::となにが違う？
  def concatでListを連結(list1: List[Int], list2: List[Int]): List[Int] = {
    List.concat(list1, list2)
  }

  def lazyZipでzipの後続で操作したい場合に生成される中間リストを作らない(list1: List[Int], list2: List[Int]): List[(Int)] = {
    // zipでの問題その1:zipの後続で操作したい場合に生成される中間リストがメモリ使う
    // zipでの問題その2:mapに渡す関数がタプルなのでプレースホルダー構文(_のこと)が使えない(無理に_使いたい動機がないような？)(なぜ出来ないかは型推論ができないから？)
    // 例1:
    // list1.zip(list2)
    //   .map { case (x, y) => x + y}
    // 例2:
    //list1.zip(list2)
    //  .map(x => x._1 + x._2

    list1.lazyZip(list2) // zipだとここで中間リストが作られるが、lazyだと遅延評価する
      .map(_ + _)
  }

  abstract class Fruit
  class Apple extends Fruit
  class Orange extends Fruit
  def apple型のListの先頭にOrange型を追加(orange: Orange): List[Fruit] = {
    val appleList: List[Apple] = new Apple :: Nil
    val fruitList:List[Fruit] = orange :: appleList
    // ::は:で終わる名称なので、appleListがレシーバーになる。のでList型のメソッドである。
    // List型の::の定義
    // def :: [B >: A](elem: B): List[B] =  new ::(elem, this)
    // BがFruitでAはApple(すでにインスタンス化されているListの型)
    // 右辺はListの中で定義されているcase classで第一引数にhead、第二引数にtailを取る
    // でもこれでなんでFruitのListができるのかよくわからない。

    fruitList
  }

  def incAll(list: List[Int]): List[Int] = {
    // 末尾再起になってないやりかた
//    list match{
//      case Nil => Nil
//      case x :: xs => x + 1 :: incAll(xs)
//    }

    // forでやる。resultの大きさがだんだん増えていくと、List結合の計算量も増えていく
//    var result = List[Int]()
//    for (x <- list) result = result ::: List(x + 1)
//    result

    // O(n)でできそうな実装
    val buffer = new ListBuffer[Int]
    for (x <- list) buffer += x + 1
    buffer.toList
  }

  def for式の文法(optionalInt: Option[Int]): Option[Int] = {
    def map向け(i: Int): Int = i + 1
    def flatMap向け(i: Int): Option[Int] = Option(i + 1)

    for {
      i <- optionalInt // ジェネレータという。seqから一つ取る(2個書くと2重ループ?)・文脈を外すとか。
      j = map向け(i) // 定義という。
      k <- flatMap向け(j) // ジェネレータで文脈を外してる。
      if(k % 2 == 0) // フィルターという。
    } yield k
  }

  def nクイーン問題(n: Int): List[List[(Int, Int)]] = {
    def クイーンが置ける場所(k: Int): List[List[(Int, Int)]] = {
      if (k == 0) List(Nil)
      else {
        for {
          現在rowより上のクイーン置ける場所 <- クイーンが置ける場所(k - 1)
          column <- 1 to n // クイーンが置けるかも知れないカラム
          // この変数名を日本語にするとコンパイルエラー(Identifiers enclosed in backticks are not pattern variables but match the value in scope.)になる。よくわからない。
          queen = (k, column)
          if is置ける(queen, 現在rowより上のクイーン置ける場所)
        } yield queen :: 現在rowより上のクイーン置ける場所
      }
    }

    def is置ける(置いてみる場所: (Int, Int), すでに置いてある場所リスト: List[(Int, Int)]): Boolean = {
      すでに置いてある場所リスト.forall { すでに置いてある場所 =>
        val 同じ行にクイーンがいない = すでに置いてある場所._1 != 置いてみる場所._1
        val 同じ列にクイーンがいない = すでに置いてある場所._2 != 置いてみる場所._2
        val 斜めにクイーンがいない = (すでに置いてある場所._1 - 置いてみる場所._1).abs != (すでに置いてある場所._2 - 置いてみる場所._2).abs

        同じ行にクイーンがいない && 同じ列にクイーンがいない && 斜めにクイーンがいない
      }
    }

    クイーンが置ける場所(n)
  }

  def 重複排除(list: List[Int]): List[Int] = list match {
    case Nil => list
    case checkTarget :: tail => checkTarget :: 重複排除(tail.filter(_ != checkTarget))
  }

  def 重複排除を末尾再起にしてみる(list: List[Int]): List[Int] = {
    // checkTargetと再起関数の結果を結合する部分がcallstackを使っているので、再帰呼出し時にcheckTargetを渡す。

    // というわけでcheckTargetのリストを作る。
    // 先頭に要素追加すると順序が変わってしまう。しかし末尾追加は計算量が上がっていくのでListBufferを使う。
    // Queueでもいいかも
    val checkTargetList = new ListBuffer[Int]

    @tailrec
    def 本体(checkTargetList: ListBuffer[Int], list: List[Int]): List[Int] = list match {
      case Nil => checkTargetList.toList
      case checkTarget :: tail => 本体(
        checkTargetList += checkTarget, // Listの末尾に追加
        tail.filter(_ != checkTarget)
      )
    }

    // それを再起関数本体に渡す。この関数はヘルパー関数みたいな感じになる。
    本体(checkTargetList, list)
  }

}