// Task 1
val employees: Seq[String] = Seq("Arei", "Antony", "Joe", "Spencer", "Jamie", "Bilal", "Roshan", "Muhammad", "Tom", "Tayamul")

val colours: Map[Int, String] = Map (
  1 -> "red",
  2 -> "yellow",
  3 -> "blue",
  4 ->  "green"
)
colours(2)

val addOne: Map[Int, String] = colours.map {
  case (key, value) => (key + 1, value)
}

val removeEvenNumbers: Map[Int, String] = colours.filter (
  num => num._1 % 2 != 0
)

val containsLetterR: Boolean = employees.exists(_.toLowerCase().contains("z"))

/**
 * Sets in Scala are collections of unique elements with no guaranteed order. They are useful for tasks requiring unique item storage and fast membership checks. Understanding the differences and use cases of sets, sequences, and maps will help you choose the appropriate collection type for your specific needs.
 */
