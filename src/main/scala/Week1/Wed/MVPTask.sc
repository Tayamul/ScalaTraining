val watermelons: Int = 8

if (watermelons > 5) {
  println("Can't carry them.")
} else if (watermelons > 3) {
  println("Needs a bag.")
} else if (watermelons > 0) {
  println("Doesn't need a bag.")
} else {
  println("Insert a valid number.")
}

println(s"John is trying to buy $watermelons watermelons.")

val bag: Boolean = true

if (watermelons <= 5 && bag == true) {
  println(s"John can buy $watermelons watermelons.")
} else {
  println(s"John cannot buy $watermelons watermelons because either he doesn't have a bag with him or there are too many for him to carry.")
}

println(f"The price of $watermelons watermelons is £${watermelons*1.397}%.2f.")