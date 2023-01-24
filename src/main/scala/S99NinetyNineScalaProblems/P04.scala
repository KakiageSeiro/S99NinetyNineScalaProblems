package S99NinetyNineScalaProblems

// 要素数を取得する
object P04 {
  def length(list: List[Int]): Int = {
    list.length
  }

  // List#foldは畳み込みではなさそう
  // https://dev.classmethod.jp/articles/scala-differece-between-fold-and-foldleft/
  // ↑URLから引用"あるデータ型の各データ構築子に１対１に対応する関数を引数にとり、レシーバの実際の値に応じて処理をするものです"
  // List#foldの定義がちょっと例外的なので下記Option#foldの定義をみて学ぶ
  // def fold[B](ifEmpty: ⇒ B)(f: (A) ⇒ B): B
  // これはNoneの場合はifEmptyを実行、Someの場合はfを実行する。
  // このようにsealed abstract classとcase classセットで定義されているもの一つずつに対応した処理をするものがScalaのfoldと理解すればよさそう？
  def tatamikomi(list: List[Int]): Int = {
    // 畳み込みではない事がわかったのでコメントアウト
    // list.fold(0)((x, y) => x + 1)

    // 真の畳み込みList#foldLeft
    // 定義
    // def foldLeft[B](z: B)(f: (B, A) => B): B
    //	zが初期値になる
    //	Aにはリストの要素が順次入ってくる
    //  Bには最初はz、次からはfの戻り値が入ってくる
    list.foldLeft(0)((x, y) => x + 1)
  }

  def tatamikomi2(list: List[Int]): Int = {
    // foldleftでは初期値を第一引数にしてたけど、こちらはlistの先頭要素が初期値になる。
    list.reduceLeft((x, y) => x + 1)
  }
}