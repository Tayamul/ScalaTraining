package Week9

object VarianceMVP extends App {

  /**
   * 1. Create an abstract Animal class with fields for their names and the food they eat. Create some animals that extend this class.
   * a) Create an Animal val and assign a more specific animal, like a Dog. Why does this compile?
   */
  abstract class Animal {
    def name: String
    def foodType: String
  }

  val dog = new Animal {
    override def name: String = "Billy"
    override def foodType: String = "Treats"
  }

  case class Dog(name: String, foodType: String) extends Animal
  val billy: Animal = Dog("Billy", "Treats")

  /*
  This works due to polymorphism. In Scala, a variable of a superclass type can hold a reference to an object of a subclass. This is because Dog is a subtype of Animal, and a Dog "is-an" Animal.
  In essence, a Dog object has all the properties and methods of an Animal, so it can be assigned to a variable of type Animal. However, if you access any properties specific to Dog, you'll need to cast it back to Dog.
     */

  /**
   * Imagine some animals are Solitary, like Cats. They don't like spending time with other Animals. Model a generic Solitary class that is invariant in its type.
   * a) Create a Solitary Cat val. Try to assign this val to a Solitary Animal val.
   * Why doesn't this compile?
   */
  class Solitary[T](val animal: T)

  case class Cat(name: String, foodType: String) extends Animal
  val solitaryCat: Solitary[Cat] = new Solitary[Cat](Cat("Whisker", "Fish"))

//  val solitaryAnimal: Solitary[Animal] = solitaryCat // Invalid.

  /*
  Assigning solitaryCat to a type Solitary[Animal] wouldn't compile because 'Solitary' is invariant in its type parameter 'T'. Invariance means that even though 'Cat' is a subtype of 'Animal', 'Solitary[Cat]' is not considered a subtype of 'Solitary[Animal]'.
  Invariance ensures type safety by preventing you from assigning a 'Solitary[Cat]' to a 'Solitary[Animal]', because doing so could lead to operations that might violate type constraints.
   */


  /**
   * Now imagine some animals like to travel in Pairs, like Swans. Create a generic
   * Pair class that is covariant in its type.
   * a) Create a val of a Pair of Swans (val swanPair: Pair[Swan]). Try to assign this val to a Pair of Animals. Will this compile? Why or why not?
   */
  class Pair[+T](val one: T, val two: T)
  case class Swan(name: String, foodType: String) extends Animal

  val swanPair: Pair[Swan] = new Pair[Swan](Swan("Swan1", "Fish"), Swan("Swan2", "Fish"))
  val animalPair: Pair[Animal] = swanPair // Valid.

  /*
  This will compile successfully because the 'Pair' class is covariant. Covariance allows the type hierarchy to be preserved. So if 'Swan' is a subtype of 'Animal', then 'Pair[Swan]' is also a subtype of 'Pair[Animal]'.
   */


  /**
   * Sometimes these animals need a person who can feed them. We're not concerned What animals they can feed. Try to model a generic abstract Feeder class that is contravariant in its type and has a feedAnimal method.
   * a) Create an Animal Feeder. Try to assign this val to a Dog Feeder. Will this compile? Why or why not?
   * b) Try to call feedAnimal from the Dog Feeder with a Dog. What do you expect to be printed?
   * c) Try to call it with a Cat. Why doesn't this compile?
   */

  abstract class Feeder[-T] {
    def feedAnimal(animal: T): Unit = println("Feeding an animal")
  }

  val animalFeeder: Feeder[Animal] = new Feeder[Animal] {
    override def feedAnimal(animal: Animal): Unit = println(s"Fed ${animal.name} some ${animal.foodType}")
  }

  val dogFeeder: Feeder[Dog] = animalFeeder // Valid.
  /*
  This will compile because the 'Feeder' class is contravariant. Contravariance means that a 'Feeder[Animal]' can be used wherever a 'Feeder[Dog]' is required, as it can handle all animals, including dogs.
   */

  val tommy: Dog = Dog("Tommy", "Meat")
  dogFeeder.feedAnimal(tommy)
  /*
  This works because dogFeeder is actually an animalFeeder, and animalFeeder knows how to feed any Animal, including Dog. The Dog object tommy is passed to the feedAnimal method, and the appropriate message is printed.
   */

  val whiskers: Cat = Cat("Whiskers", "Fish")
  dogFeeder.feedAnimal(whiskers)
  /*
  this doesn't compile because the type of 'dogFeeder' is 'Feeder[Dog]', which means it expects only 'Dog' objects. Even though 'dogFeeder' is actually an 'animalFeeder', the type sees 'dogFeeder' as a 'Feeder[Dog]', so you cannot pass 'Cat' to it.
  The compiler enforces this restriction to prevent type-safety violations. If you could pass a 'Cat' to a 'Feeder[Dog]', it could lead to unsafe operations specific to 'Dog' that wouldn't work with a 'Cat'.
   */
}
