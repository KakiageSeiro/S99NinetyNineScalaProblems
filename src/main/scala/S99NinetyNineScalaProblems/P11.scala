package S99NinetyNineScalaProblems

object P11 {
  def runLength[T](list: List[T]): List[Any] =
    P10.runLength(list) map {
      case (1, x) => x
      case (n, x) => (n, x)
    }
}