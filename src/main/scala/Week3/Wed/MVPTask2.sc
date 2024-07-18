
/** Task 2 Given this data:
 • Full Name
 • Date of Birth
 • Occupation
 • Last Country lived in
 • Date of Death
 Only the fields Full Name, Date of Birth, Last Country lived in are required.
 Create a method that accepts the above data and makes a Person case class from this data.
 The Person case class should also include their age, star sign. If they have a dateOfDeath it should include their ageAtDeath.
 */

/**
 PRACTICE VERSION

 case class Person (fullName: String, dateOfBirth: String, lastCountryLivedIn: String, age: Int, starSign: String, dateOfDeath: Option[String], ageAtDeath: Option[Int])
 //  val occupation: String = "Backend Developer"

 def instantiatePerson (fullName: String, dateOfBirth: String, lastCountryLivedIn: String, age: Int, starSign: String, dateOfDeath: String, ageAtDeath: Option[Int]): Option[Person] = {
 if (dateOfDeath.contains("")) Some (new Person(fullName, dateOfBirth, lastCountryLivedIn, age, starSign, dateOfDeath = Some(dateOfDeath), ageAtDeath)) else None
 }

 instantiatePerson("Michael Jackson", "01/01/2001", "UK", 48, "Pisces", "", Some(58))
 //  val Mike = Person("Mike Tyson", "01/01/1978", "UK")
 **/

/** Actual Implementation */
import java.time.{LocalDate, Period}
import java.time.format.DateTimeFormatter

case class Person(
                   fullName: String,
                   dateOfBirth: LocalDate,
                   lastCountryLivedIn: String,
                   age: Int,
                   starSign: String,
                   dateOfDeath: Option[LocalDate] = None,
                   ageAtDeath: Option[Int] = None
                 )

object PersonCreator {

  def calculateAge(dateOfBirth: LocalDate, dateOfDeath: Option[LocalDate] = None): Int = {
    dateOfDeath match {
      case Some(dod) => Period.between(dateOfBirth, dod).getYears
      case None => Period.between(dateOfBirth, LocalDate.now()).getYears
    }
  }

//  calculateAge("2001-01-01", Some("2023-01-01"))

  def getStarSign(dateOfBirth: LocalDate): String = {
    val day = dateOfBirth.getDayOfMonth
    val month = dateOfBirth.getMonthValue

    month match {
      case 1 => if (day <= 19) "Capricorn" else "Aquarius"
      case 2 => if (day <= 18) "Aquarius" else "Pisces"
      case 3 => if (day <= 20) "Pisces" else "Aries"
      case 4 => if (day <= 19) "Aries" else "Taurus"
      case 5 => if (day <= 20) "Taurus" else "Gemini"
      case 6 => if (day <= 20) "Gemini" else "Cancer"
      case 7 => if (day <= 22) "Cancer" else "Leo"
      case 8 => if (day <= 22) "Leo" else "Virgo"
      case 9 => if (day <= 22) "Virgo" else "Libra"
      case 10 => if (day <= 22) "Libra" else "Scorpio"
      case 11 => if (day <= 21) "Scorpio" else "Sagittarius"
      case 12 => if (day <= 21) "Sagittarius" else "Capricorn"
    }
  }

  def createPerson(
                    fullName: String,
                    dateOfBirth: String,
                    lastCountryLivedIn: String,
                    dateOfDeath: Option[String] = None
                  ): Person = {
    val dob = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_DATE)
    val dod = dateOfDeath.map(LocalDate.parse(_, DateTimeFormatter.ISO_DATE))
    val age = calculateAge(dob, dod)
    val starSign = getStarSign(dob)
    val ageAtDeath = dod.map(_ => age)

    Person(fullName, dob, lastCountryLivedIn, age, starSign, dod, ageAtDeath)
  }

}

val person = PersonCreator.createPerson(
  fullName = "John Doe",
  dateOfBirth = "1980-07-15",
  lastCountryLivedIn = "USA",
  dateOfDeath = Some("2023-06-25")
)

println(person)


/** Task 3
 *Create a method called horoscope. This method should accept a LocalDate and return a tuple of their star sign and their horoscope. Use pattern matching in your method.
 * */
