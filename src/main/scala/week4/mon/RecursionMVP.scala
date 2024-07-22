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
}
