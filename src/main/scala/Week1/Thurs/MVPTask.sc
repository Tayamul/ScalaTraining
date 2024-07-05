// Task 1
val num: List[Int] = List(1, 2, 3, 4, 5)
val primaryColours: Seq[String] = Seq("red", "blue", "yellow")

val multiplyByThree: List[Int] = num.map(_* 3)

val removeBlueFromTheSeq: Seq[String] = primaryColours.filter(_.toLowerCase() != "blue")

val seqContainsOrange: Boolean = primaryColours.contains("orange")

// Task 2 - Go through each value in your List of numbers and return true if they are odd and false if they are even.

val oddOrEven: List[Boolean] = num.map {
  _ % 2 != 0
}


// Task 3 - David has a lot of pets. Decide what pets he has (must include at least 1 dog) and write these in a Map.

val davidsPets: Map[String, List[String]] = Map(
  "dog" -> List("Kenji", "Seru", "Aturi"),
  "cat" -> List("Whiskers"),
  "fish" -> List("Aqua", "Finley", "Splash", "Coral", "Bubbles"),
  "snake" -> List("Slither"),
)

val removeDog = davidsPets("dog")

// Task 4 - Return a List of the names of David's dog(s).
println(s"Name of David's dogs: ${davidsPets("dog").mkString(", ")}.")