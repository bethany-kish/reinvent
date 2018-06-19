package reinvent

object Head {
  def apply[A](input: List[A]): A = input match {
    case Nil => throw new RuntimeException("Head of empty list")
    case (h::_) => h
  }
}

object Filter {
  def apply[A](items: List[A], predicate: A => Boolean): List[A] = {
    def applyFilter(items: List[A], accumulator: List[A]) : List[A] = {

      if (items.isEmpty)  return accumulator

      else if (predicate(items.head)) {
        applyFilter(items.tail, accumulator :+ items.head)
      }

      else {
        applyFilter(items.tail, accumulator)
      }
    }
    applyFilter(items, List())
  }
}

