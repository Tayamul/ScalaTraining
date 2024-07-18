/** Using pattern matching, when given a string of the name of a country your pattern match should return that countries capital city. */

val country: String = "Scotland"

country.toLowerCase().trim() match {
  case "england" => "London"
  case "nepal" => "Kathmandu"
  case "japan" => "Tokyo"
  case "brazil" => "Brasilia"
  case "canada" => "Ottawa"
  case _ => s"Capital city of $country is not in the list."
}

