/**
 * Task 1 - What are three main differences between a class and a case class?
 * Case class is a 'pimped-up' version of a class.
 * It has additional built-in methods which we can utilise for our ease of programming.
 * It does not require the keyword 'new' to instantiate an object.
 * We can easily create an object variable without having to inherit from the case class.
 */

/** Task 2 - Which of the following lines of code is runnable and which will produce an error? */
case class Person (name: String, age: Int, nationality: String, isStudent: Boolean) // runnable
val firstPerson = new Person("Carlos", 23, "Spanish", true) // not runnable
val secondPerson = Person("Carlos", 23, "Spanish", true) // runnable
val thirdPerson = Person("Carlos", 23, "Spanish", true) // runnable

class Animal (name: String, colour: String, pet: Boolean)
val cat = Animal ("cat", "black", true) // not runnable
val dog: Animal = new Animal ("cat", "white", true) // runnable, but in order to read/use the parameter's value, we need to declare the params as a val


/** Task 3 - After reviewing all combinations, which ones are true when compared using the "==" operator? */
case class Muffin (flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin ("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin ("blueberry", 3.50, "Mercator Bakery")
val vanillaMuffin = Muffin ("vanilla", 3.50, "Mercator Bakery")
val anotherChocolateMuffin = Muffin ("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin ("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin ("choocolate", 2.50, "Mercator Bakery")

/**
 * After reviewing all combinations listed above, the only two objects that return a true value when compared to each other are chocolateMuffin and anotherChocolateMuffin. The flavour of oneMoreChocolateMuffin has a capitalised word, and since Scala is case-sensitive, its value won't equal 'chocolate'.
 */