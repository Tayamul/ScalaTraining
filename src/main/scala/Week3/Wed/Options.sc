/**
 * Often used to replace exceptions that can be thrown when we have parameters that might be present, might not. We don’t have to waste time checking for something that isn’t there!
 * We can pattern match on these too!
 * Option – ‘some’ or ‘none’
 */

trait Pizza {
  val size: Int
  val crust: Option[String]
}

object Personal extends Pizza {
  val size: Int = 7
  val crust: Option[String] = None
}

object smallClassic extends Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("classic")
}

object smallItalian extends Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("Italian")
}

val pizzaOrder: Pizza = new Pizza {
  override val size: Int = 9
  override val crust: Option[String] = Some("ITALIAN")
}

def whatCrust (pizza: Pizza): String = {
  pizza.crust map (_.toLowerCase) match {
    case Some("classic") => "classic crust"
    case Some("italian") => "italian crust"
    case Some(x) => s"$x is not a valid crust type" // error handling - in case no value matches
    case None => "Default crust - classic"
  }
}

whatCrust(pizzaOrder)

// .get
val getCrust: String = pizzaOrder.crust.get // bad practice because it won't work when the string is empty

// .getOrElse - allows for a default to be given
val getOrElseCrust: String = pizzaOrder.crust.getOrElse("classic")