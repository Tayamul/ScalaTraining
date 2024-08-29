package Week9

object Variance extends App {

  /** Covariance [+T] */

  abstract class Coffee {
    def name: String
  }

  // Sub-classes of Coffee
  case class Standard (name: String) extends Coffee
  case class Fancy (name: String) extends Coffee

  def coffeeMenu(coffees: List[Coffee]): String = {
    coffees.foreach {
      coffee => println(coffee.name)
    }.toString
  }

  // implicitly covariant
  val standardCoffeeMenu: List[Standard] = List(Standard("Latte"), Standard("Cappuccino"), Standard("Americano"))
  val fancyCoffeeMenu: List[Fancy] = List(Fancy("Mocha"), Fancy("Iced"), Fancy("Chai"))

  println("Standard coffee menu: ") + coffeeMenu(standardCoffeeMenu)
  println("Fancy coffee menu: ") + coffeeMenu(fancyCoffeeMenu)


  /** Contravariance [-T] */

  abstract class SummerActivity[-T] {
    def printValue(value: T): String
  }

  // Super-class
  abstract class Festival {
    def name: String
  }

  // Sub-class of Festival
  case class MusicFestival(name: String) extends Festival

  // Sub-class of SummerActivity
  // Super-type
  class Glastonbury extends SummerActivity[Festival] {
    override def printValue(festival: Festival): String = festival.name
  } // This class can handle any type of festival.

  // Sub-type
  class Reading extends SummerActivity[MusicFestival] {
    override def printValue(festival: MusicFestival): String = festival.name
  } // This class can only handle MusicFestival. This class is far more specific than Glastonbury class.

  val newMusicFestival: MusicFestival = MusicFestival("New Music Festival")

  def printNewFestival(summerActivity: SummerActivity[MusicFestival]): String = {
    summerActivity.printValue(newMusicFestival)
  }

  val festival1: SummerActivity[Festival] = new Glastonbury // Valid. Same type.
  val festival2: SummerActivity[MusicFestival] = new Glastonbury // Valid. Glastonbury has the type SummerActivity[Festival] and due to Contravariance, it's compatible with the sub-type of SummerActivity[MusicFestival]
//  val festival3: SummerActivity[Festival] = new Reading // Not valid. Reading has type SummerActivity[MusicFestival] and this is a sub-type of SummerActivity[Festival]. I cannot pass a sub-type in where a super-type is expected.
  // Can only move Super-types down, but not Sub-types up.
  val festival4: SummerActivity[MusicFestival] = new Reading // Valid. Type match.

  println(printNewFestival(festival1))
  println(printNewFestival(festival2))
  println(printNewFestival(festival4))


  /** Invariance [T]
   * Helps with type safety - but really rigid.
   * Structured!
   * */

  class Box[T] (var contentOfBox: T) // a generic class that holds a value of type 'T' in its contentOfBox parameter.

  abstract class Fruit {
    def variety: String
  }

  case class Apple(variety: String) extends Fruit
  case class Orange(variety: String) extends Fruit
  // NOTE: Apple and Orange are sub-types of Fruit.

  val appleBox: Box[Apple] = new Box[Apple](Apple("Gala"))
//  val fruitBox: Box[Fruit] = appleBox // Wouldn't work.


}