package S99NinetyNineScalaProblems

// リストの回文判定
object P06 {
  def isPalindrome(list: List[Int]): Boolean = {
    // 奇数の場合でも真ん中の数は見なくてよい
    for (i <- 0 until list.length / 2) {
      if (list(i) != list(list.length - i - 1)) {
        return false
      }
    }

    true
  }

}