package sandbox.素振り

import scala.annotation.tailrec

object Factorial {
  def forで階乗(target: Int): BigDecimal = {
    var result = BigDecimal(1)
    for (i <- 2 to target) {
      result *= i
    }

    result
  }

  // IntelliJだと関数定義の左側のデバッグポイント仕込めるところに渦巻きマークがでる。多分末尾再起ではない再起のこと。
  def 再起で階乗(かける値: Int): BigDecimal = かける値 match {
    case 1 => 1
    case _ => かける値 * 再起で階乗(かける値 - 1)
  }

  // IntelliJだと関数定義の左側のデバッグポイント仕込めるところにウロボロスマークがでる。多分末尾再起のこと。
  @tailrec
  def 再起で階乗_改(かける値: Int, 初期値: BigDecimal): BigDecimal = かける値 match {
    case 1 => 初期値
    case _ => 再起で階乗_改(かける値 - 1, 初期値 * かける値)
  }

  // ■ここは階乗ではないけど↑が引数の名前とかがイケてなくて分かりにくいと思ったので理解用
  // 再起を考える時はforで書いてみた時にスコープの中で使われている変数が、再起関数の引数になると考える
  // forがいつもやってくれているiをインクリメントしたりする部分も、再起では自分でやるということを考えると、forの変数の数と再起の引数の数は同じになる
  //
  // forの時は↓こんな感じだとする
  // int result = 0
  // for(int i = 1; i <= element; i++){i + result} // 1始まりに注意
  @tailrec
  def 一からelementまでを全て足す(element: Int, result: Int): Int = element match {
    // 終了条件。"1からelement"は逆である"elementから1"でもおK。
    // 1の時はforで言うと最後のループ。なので計算してreturnする
    case 1 => result + 1

    // 第一引数はforのiをインクリメント(デクリメント)するところ。for(int i=0;i<2;i++)の一番右。
    // 第二引数は計算の本体。forの中身に相当。
    case _ => 一からelementまでを全て足す(element - 1, result + element)
  }

  def 一からelementまでを全て足す関数を初期値0で始める(element: Int): Int =
    一からelementまでを全て足す(element, 0)

  // このforの例により近い書き方(初心者のウチはこれでもいいんじゃなかろうか)for文はi(初期値)と終了条件の2つの引数を取ってるってことだったんだな
  // int result = 0
  // for(int i = 1; i <= element; i++){i + result} // 1始まりに注意
  //
  // iはforのindex、elementはforの括弧の中2番目の終了条件(なので名前よくないけど↑との対比ってことで)
  @tailrec
  def forと同じようにiがインクリメントしていく処理の流れの足し算(i:Int, element: Int, result: Int): Int = i match {
    // for文の文化だと1ずつインクリメントするのに終了条件はi <= elementのように記述するのって、==で良いのでは感があるな…なんでだろう
    // elementと同じ数字の時はforで言うと最後のループ。
    case i if i == element => result + i
    // i==elementではなくelementとだけ書くとIntで型がマッチする(多分)ので全ての呼出しで合致しちゃう
    // とおもったけど、これは_(ワイルドカード)とはまた別の変数パターン(variable pattern)というやつらしい。全ての値にマッチするみたい。_とは値を変数に束縛しないところだけが違うっぽい。

    // 第二引数は終了条件なのでずっとかわらない。この関数をヘルパーにしてelementを引数にとらない関数を切り出しても良いかも。でもそれだけのために関数増やす？修正されることを考慮しなければ説明変数ですよってことでも良い気がする。
    // 第三引数は計算の本体。forの中身に相当。
    case _ => forと同じようにiがインクリメントしていく処理の流れの足し算(i + 1, element, result + i)
  }
}