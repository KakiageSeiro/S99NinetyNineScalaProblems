package S99NinetyNineScalaProblems

object P16 {
  def drop[T](n : Int, list: List[T]): List[T] = {
    list.zipWithIndex.filterNot { case (_, i) => (i + 1) % n == 0 }.map(_._1)
  }
}