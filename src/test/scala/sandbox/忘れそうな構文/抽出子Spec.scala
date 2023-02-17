package sandbox.忘れそうな構文

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec
import sandbox.忘れそうな構文.抽出子.{Domain, EMail, TrueEmailAddressUser, TrueEmailAddressUser2, UpperCase}

class 抽出子Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "unapplyで" should "分解" in {
    assert(EMail.unapply("kakiage@yahoo.co.jp") == Some("kakiage", "yahoo.co.jp"))
    assert(EMail.unapply("kakiage").isEmpty)
  }

  "unapplyがあることで" should "パターンとして使える" in {
    val str = "kakiage@yahoo.co.jp"
    str match {
      case EMail(user, domain) => assert(user == "kakiage" && domain == "yahoo.co.jp")
      case _ => fail()
    }
  }

  "unapplyがない" should "パターンとして使えない" in {
    // Email2を解決できなくてコンパイルエラー
//    val str = "kakiage@yahoo.co.jp"
//    str match {
//      case EMail2(user, domain) => assert(user == "kakiage" && domain == "yahoo.co.jp")
//      case _ => fail()
//    }
  }

  "引数がunapplyと違う場合は" should "コンパイルエラー" in {
//    val int: Int = 123
//    int match {
//      case EMail(user, domain) => assert(user == "kakiage" && domain == "yahoo.co.jp")
//      case _ => fail()
//    }
  }

  "値を束縛しない" should "やーつ" in {
    val str = "KAKIAGE"
    str match {
      case UpperCase() => assert(true)
      case _ => fail()
    }
  }

  "組み合わせて" should "パターンとして使える" in {
    val str = "KAKIAGE@yahoo.co.jp"
    str match {
      // user @ UpperCase()という記法を使っている
      // 変数束縛パターンというやつで、パターンマッチが成功したときにstrを式(ここではUpperCase()の事だと思う)の中で利用できる
      // EMail()という、()をつかってるので呼出しの文法っぽさがあるが、そうではなく後続処理(=>の次)で利用する変数の束縛を()の中で定義するイメージかも
      // なので？UpperCase(user)はコンパイルエラーになる
      // UpperCaseはboolを返すだけなので
      case EMail(user @ UpperCase(), domain) => assert(user == "KAKIAGE" && domain == "yahoo.co.jp")
      case _ => fail()
    }
  }

  "戻り値が固定長ではないunapplySeqを" should "パターンとして使える" in {
    val str = "yahoo.co.jp"
    str match {
      case Domain(a) => fail()
      case Domain(a, b) => fail()
      case Domain(a, b, c) => assert(a == "jp" && b == "co" && c == "yahoo")
      case _ => fail()
    }
  }

  "ユーザー定義型が返ってくる抽出子" should "パターンとして使える" in {
    val str = "kakiage.seiro"
    str match {
      case TrueEmailAddressUser(str) => assert(str === "kakiage.seiro")
      case _ => fail()
    }
  }

  "ユーザー定義型がタプルで返ってくる抽出子" should "パターンとして使える" in {
    val str = "kakiage.seiro"
    str match {
      case TrueEmailAddressUser2(first, last) => assert(first === "kakiage" && last === "seiro")
      case _ => fail()
    }
  }

}













