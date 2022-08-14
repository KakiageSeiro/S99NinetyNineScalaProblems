package S99NinetyNineScalaProblems

import org.scalatest.concurrent.TimeLimits
import org.scalatest.diagrams.Diagrams
import org.scalatest.flatspec.AnyFlatSpec

class P06Spec extends AnyFlatSpec with Diagrams with TimeLimits {
  "isPalindrome" should "回文である" in {
    assert(P06.isPalindrome(List(1, 2, 3, 2, 1)))
    assert(P06.isPalindrome(List(1, 2, 3, 3, 2, 1)))
  }
  "isPalindrome" should "回文でない" in {
    assert(!P06.isPalindrome(List(1, 3, 3, 2, 1)))
    assert(!P06.isPalindrome(List(5, 2, 3, 2, 1)))
    assert(!P06.isPalindrome(List(1, 2, 4, 3, 2, 1)))
  }


}
