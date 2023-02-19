package S99NinetyNineScalaProblems

object P10 {
  def runLength[T](list: List[T]): List[(Int, T)] =
    P09.pack(list).map(x => (x.length, x.head))
}