/**
 * Pattern matching works in a similar way to if/else statements. A cleaner way to write code.
 * Vals traits, objects, enums and more
 * Things to consider - Wildcards '_' ( values that we haven’t accounted for).
 */

  // Match of Vals

val weather: String = "Cold"

if (weather == "cold") {
  println("Take a coat.")
} else if (weather == "rain") {
  println("Take an umbrella.")
} else {
  println("Take nothing.")
}

weather.toLowerCase() match {
  case "cold" => println("Take a coat.")
  case "rain" => println("Take an umbrella.")
  case _ => println(s"$weather is not valid.")
}

// Match of int
// if guard - be careful of the ordering.

val numOfWatermelons: Int = 3
numOfWatermelons match {
  case x if x <= 0 => println("Must be more than zero.")
  case 1  | 2 | 3 => println("John can carry these without a bag.")
  case 4 | 5 => println("John needs a bag.")
  case _ => println(s"$numOfWatermelons is invalid.")
}

// Matching off objects
// 'sealed' can only be extended within the same file that it is defined on
sealed trait Temperature // use trait if there is only one attribute
object Cold extends Temperature
object Hot extends Temperature
object Mild extends Temperature

val weather: Temperature = Hot

weather match {
  case Cold => "Take a coat."
  case Hot => "Wear sun cream"
  case Mild => "Light Jacket"
//  case _ => "Not valid"
}

// Match using classes

abstract class Notification // Cannot be instantiated - must be extended!!
case class Email (sender: String, title: String, body: String) extends Notification
case class SMS (caller: String, message: String) extends Notification
case class VoiceRecording (contactName: String, link: String) extends Notification

val notification: Notification = SMS("Mum", "Are you home?")

notification match {
  case Email(sender, title, body) => "Email from " + sender + "Title: " + title
  case SMS (caller, message) if caller == "Mum" => "SMS from " + caller + ". Don't ignore."
  case SMS(caller, message) => "SMS from " + caller
  case VoiceRecording(contactName, link) => "Recording from " + contactName + "With link: " + link
  case _ => "Not valid!"
}

/**
 * Task 1 - Accept a string for a flavour/topping and return a different type of pizza for each one.
 */

//val pepperoni: String = "Pepperoni"
//val cheese: String = "Cheese"
//val chicken: String = "Chicken"
//val mushrooms: String = "Mushrooms"
//val bacon: String = "Bacon"
//val tomatoes: String = "Tomatoes"
//val greenPepper: String = "Green pepper"
//
//val typeOfPizza: String = "spicy"
//
//typeOfPizza match {
//  case "spicy" => "American Hot"
//  case _ => "Not valid!"
//}

//

val typeOfPizza: String = "chicken"

typeOfPizza match {
  case "spicy" => "American Hot"
  case "chicken" | "beef" => "Meat Feast"
  case "cheese" | "tomato" => "Margarita"
  case _ => "It's not a pizza!"
}

val pizzaMeasurements: List[Int] = List(7, 9, 11, 14)

case class Pizza (price: Int, crustParameters: Double)