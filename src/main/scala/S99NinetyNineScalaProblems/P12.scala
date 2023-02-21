package S99NinetyNineScalaProblems

object P12 {
  def runLengthDecode[T](list: List[(Int, T)]): List[T] =
    list flatMap {
      case (n, x) => List.fill(n)(x)
    }
}