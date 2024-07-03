val weather: String = "rain"
val season: String = "winter"

/*
if (weather == "cold" && season == "winter") {
  println(s"It is $weather! Take a coat.")
} else {
  println("Don't take a coat!")
}
*/

if (weather == "cold") {
  println("Take a coat.")
} else if (weather == "rain") {
  println("Take an umbrella.")
} else {
  println("Take nothing.")
}

// Task 1
val score: Int = 109

if (score >= 90 && score <= 100) {
  println("A")
} else if (score >= 80 && score < 90) {
  println("B")
} else if (score >= 70 && score < 80) {
  println("C")
} else if (score >= 60 && score < 70) {
  println("D")
} else if (score >= 50 && score < 60) {
  println("E")
} else if (score < 50) {
  println("F")
} else {
  println("Invalid.")
}

// Task 2
val age: Int = 4

if (age >= 18) {
  println("18 and over.")
} else if (age >= 15) {
  println("15+")
} else if (age >= 12) {
  println("The movie is rated 12A.")
} else if (age >= 8) {
  println("The movie is rated PG.")
} else if (age >= 4) {
  println("The movie is rated U.")
} else {
  println("Not suitable to watch.")
}