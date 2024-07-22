package week4.mon

import scala.annotation.tailrec

object RecursionMVP extends App {

/** Task 1 - Create an object that extends Enumeration. Provide all the teams participating in the Euro 2024. Now write a tail recursive method to print all the teams. */
  object Euro24 extends Enumeration {
  type Euro24 = Value
  val England, Spain, Germany, France, Netherlands, Turkey, Portugal, Switzerland, Austria, Belgium, Denmark, Georgia, Italy, Romania, Slovakia, Slovenia, Albania, Croatia, Czechia, Hungary, Poland, Scotland, Serbia, Ukraine = Value
}

  @tailrec
  def printAllTeams (teams: List[Euro24.Value], acc: String): String = {
    teams match {
      case Nil => acc
      case ::(head, tail) =>
        val makeNiceToRead: String = if (acc.isEmpty) "" else ", "
        printAllTeams(tail, acc + makeNiceToRead + head.toString)
    }
  }

  val allTeams = Euro24.values.toList
  println("\nList of Teams in Euro24: " + printAllTeams(allTeams, ""))



  /** Task 2 - Now can you do the same as Task 1, but instead of using Enumeration, implement it using case objects. Make a sealed class of Team which has a constructor parameter
   'name' which is type string and a companion object with the same name. Enter the case objects inside the companion object. What do you notice about accessing the values? */

  sealed trait EuroTeams {
    def name: String
  }

  object EuroTeams {
    case object England extends EuroTeams {val name = "England"}
    case object Spain extends EuroTeams {val name = "Spain"}
    case object Germany extends EuroTeams { val name = "Germany" }
    case object France extends EuroTeams { val name = "France" }
    case object Netherlands extends EuroTeams { val name = "Netherlands" }
    case object Turkey extends EuroTeams { val name = "Turkey" }
    case object Portugal extends EuroTeams { val name = "Portugal" }
    case object Switzerland extends EuroTeams { val name = "Switzerland" }
    case object Austria extends EuroTeams { val name = "Austria" }
    case object Belgium extends EuroTeams { val name = "Belgium" }
    case object Denmark extends EuroTeams { val name = "Denmark" }
    case object Georgia extends EuroTeams { val name = "Georgia" }
    case object Italy extends EuroTeams { val name = "Italy" }
    case object Romania extends EuroTeams { val name = "Romania" }
    case object Slovakia extends EuroTeams { val name = "Slovakia" }
    case object Slovenia extends EuroTeams { val name = "Slovenia" }
    case object Albania extends EuroTeams { val name = "Albania" }
    case object Croatia extends EuroTeams { val name = "Croatia" }
    case object Czechia extends EuroTeams { val name = "Czechia" }
    case object Hungary extends EuroTeams { val name = "Hungary" }
    case object Poland extends EuroTeams { val name = "Poland" }
    case object Scotland extends EuroTeams { val name = "Scotland" }
    case object Serbia extends EuroTeams { val name = "Serbia" }
    case object Ukraine extends EuroTeams { val name = "Ukraine" }

    val allTeams: List[EuroTeams] = List(England, Spain, Germany, France, Netherlands, Turkey, Portugal, Switzerland, Austria, Belgium, Denmark, Georgia, Italy, Romania, Slovakia, Slovenia, Albania, Croatia, Czechia, Hungary, Poland, Scotland, Serbia, Ukraine)
  }

  /** Values are accessed directly through the companion object.
   * Using sealed traits and case objects provides more flexibility in defining additional behaviour and properties for each case.
   * Sealed traits and case objects work seamlessly with pattern matching.
   * It offers type safety -  as all the possibilities of subtypes are known at compile-time, enhancing type safety.
   * Improves readability and maintainability by clearly defining finite set of related types.
   * */

  def printTeamsUsingCaseObject (teams: List[EuroTeams], acc: String): String = {
    teams match {
      case Nil => acc
      case ::(head, tail) =>
        val makeNiceToRead: String = if (acc.isEmpty) "" else ", "
        printTeamsUsingCaseObject(tail, acc + makeNiceToRead + head.name)
    }
  }

  println("\nList of Euro Teams using case object: " + printTeamsUsingCaseObject(EuroTeams.allTeams, ""))

}