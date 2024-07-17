/**
 * Finite sets of data
 */

/** Native (vs sealed case objects on Friday 19th July) */
object Weekday extends Enumeration {
  // each are values or a variable.
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}
Weekday.Monday.toString

// can set-up acronyms to improve readability
// useful for acronyms/long names
// zero indexed
object BetterWeekday extends Enumeration {
  val Monday = Value("Mon")
  val Tuesday = Value("Tue")
  val Wednesday = Value("Wed")
  val Thursday = Value("Thurs")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")
}
BetterWeekday.Saturday
Weekday.values
Weekday.Monday < Weekday.Sunday /// ordered by index position

// you can reorder the position using integers.
object ReOrderWeekday extends Enumeration {
  val Monday = Value(1)
  val Tuesday = Value(2)
  val Wednesday = Value(3)
  val Thursday = Value(4)
  val Friday = Value(5)
  val Saturday = Value(6)
  val Sunday = Value(0)
}
ReOrderWeekday.values

/** Enums are similar to sealed traits in a sense that there are finite set of data */

def exhaustiveMatch (weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "YAYY Mon"
    case BetterWeekday.Tuesday => "Tue"
    case BetterWeekday.Wednesday => "Wed"
    case BetterWeekday.Thursday => "Thurs"
    case BetterWeekday.Friday => "Fri"
    case BetterWeekday.Saturday => "Sat"
    case BetterWeekday.Sunday => "Sun"
  }
}

exhaustiveMatch(BetterWeekday.Monday)

// Be careful
def nonExhaustiveMatch (weekday: BetterWeekday.Value): String = {
  weekday match {
    case BetterWeekday.Monday => "Mon"
    case BetterWeekday.Tuesday => "Tue"
  }
}

/** Sealed case objects - more boilerplate!
 * difference between enums - HAVE to do exhaustive match!
 * improves safety - provides with extra warning in the build tab
 * sealed case objects MUST be exhaustive - will see compilation warning if not
 * 'object Sunday
 * warning: previously defined object Weekday is not a companion to trait Weekday.
 * 'Companions must be defined together; you may wish to use :paste mode for this.'
 * NO EASY WAY TO ACCESS ALL VALUES!!
 * NO DEFAULT ORDERING!! ie. 0 -> 6 'mon -> sun'
 * Can create own method to order the list though.
 *
 * PROS vs CONS
 * */
sealed trait Weekday
case object Monday extends Weekday
case object Tuesday extends Weekday
case object Wednesday extends Weekday
case object Thursday extends Weekday
case object Friday extends Weekday
case object Saturday extends Weekday
case object Sunday extends Weekday

def caseObjectMatch (weekday1: Weekday): String = {
  weekday1 match {
    case Monday => "Yayy its Monday"
    case Tuesday => "We love Scala!"
    case Wednesday => "Lesgooo"
    case Thursday => "Ahhhhhh!"
    case Friday => "TGIF"
    case Saturday => "Hungover"
    case Sunday => "Re-energise"
  }
}


abstract class Error (name: String, errorCode: Int)
case object WeekdayNotFound extends Error (name = "Weekday not found", errorCode = 404)

/** Task */

object Friends extends Enumeration {
  val Joey = Value("Joey")
  val Rachel = Value("Rachel")
  val Ross = Value("Ross")
  val Chandler = Value("Chandler")
  val Monica = Value("Monica")
  val Phoebe = Value("Phoebe")
}
Friends.values
Friends.values.toString()

sealed trait Friends
case object Joey extends Friends
case object Rachel extends Friends
case object Ross extends Friends
case object Chandler extends Friends
case object Monica extends Friends
case object Phoebe extends Friends

def charactersFromFriends (friends: Friends): String = {
  friends match {
    case Joey => "Joey"
    case Rachel => "Rachel"
    case Ross => "Ross"
    case Chandler => "Chandler"
    case Monica => "Monica"
    case Phoebe => "Phoebe"
  }
}