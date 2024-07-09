/**
 * Case classes
 * Extra methods attached to it:
 * - an apply method
 * - an unapply method
 * - hashcode and equals method
 * - copy method
 * - toString method
 *
 * DON'T need to instantiate object
 * Can call methods on classes
 */

case class SuperHero (val realName: String, val heroName: String, val weakness: String)

/**
 * Apply methods
 * Use it to make objects
 */
val newSuperHero: SuperHero = SuperHero.apply(realName = "Clark Kent", heroName = "Superman", weakness = "Kryptonite")
/**
 * OR write it out
 * Don't need to use the keyword 'new' to create an object
 */
val anotherNewSuperHero: SuperHero = SuperHero("Clark Kent", "Superman", "Kryptonite")

/**
 * == comes true as it is comparing the values within the objects (what makes the objects), and not the identity (name) of the objects
 */

newSuperHero == anotherNewSuperHero

/**
 * Copy method
 * Used especially when a class uses lots of parameters.
 */

val updateName: SuperHero = anotherNewSuperHero.copy(realName = "Clark Lane")


/**
 * CASE OBJECTS
 * Can have exhaustive matching!
 * Has limited options available for the users so they can only pick one of the other options. CANNOT ADD THEIR OWN CHOICES/ANSWERS
 * We can extend the case classes
 */
case object Hulk
case object Superman


/** Tasks */

case class Dog (val name: String, val breed: String, val age: Int)

val Dog1: Dog = Dog(name = "Billy", breed = "Husky", age = 4)
val Dog2: Dog = Dog(name = "Tommy", breed = "German Shepherd", age = 7)
val Dog3: Dog = Dog(name = "Angelo", breed = "Bulldog", age = 2)
val Dog4: Dog = Dog(name = "Mike", breed = "Husky", age = 6)

case class Kennel (val name: String, val dogs: List[Dog])

val kennel: Kennel = Kennel(name = "Kennel House", dogs = List(Dog1, Dog2, Dog3, Dog4))
val updatedKennelName: Kennel = kennel.copy(name="Kennel Club")

case class Cat (val name: String, val age: Int)
val Cat1: Cat = Cat(name = "Mew", age = 3)
val Cat2: Cat = Cat(name = "Mewto", age = 1)
val Cat3: Cat = Cat(name = "Jiggly", age = 6)

case class Bird (val name: String, val age: Int)
val Bird1: Bird = Bird(name = "Birdie", age = 2)
val Bird2: Bird = Bird(name = "Eagle", age = 6)
val Bird3: Bird = Bird(name = "Par", age = 1)

case class UpdatedKennel (val name: String, val dogs: List[Dog], val cats: List[Cat], val birds: List[Bird]) {
  def addANewDog (dogName: String, dogBreed: String, dogAge: Int): UpdatedKennel = {
    val newDog = Dog(dogName, dogBreed, dogAge)
    UpdatedKennel(name, dogs :+ newDog, cats, birds)
  }

  def addANewCat (catName: String, catAge: Int): UpdatedKennel = {
    val newCat = Cat(catName, catAge)
    UpdatedKennel(name, dogs, cats :+ newCat, birds)
  }

  def addANewBird (birdName: String, birdAge: Int): UpdatedKennel = {
    val newBird = Bird(birdName, birdAge)
    UpdatedKennel(name, dogs, cats, birds :+ newBird)
  }
}

// Creating an instance of UpdatedKennel with an initial list of parameters
val initialKennel: UpdatedKennel = UpdatedKennel("Kennel Club", List(Dog1, Dog2, Dog3, Dog4), List(Cat1, Cat2, Cat3), List(Bird1, Bird2, Bird3))

// Updating the Kennel with new lists
val updatedKennel: UpdatedKennel = initialKennel.addANewDog(dogName = "Ghetts", dogBreed = "Husky", dogAge = 2)
val updatedKennel2: UpdatedKennel = updatedKennel.addANewDog(dogName = "Ghetto", dogBreed = "Husky", dogAge = 10)
val updatedKennel3: UpdatedKennel = updatedKennel2.addANewCat(catName = "Bill", catAge = 6)
val updatedKennel4: UpdatedKennel = updatedKennel3.addANewBird(birdName = "Double Par", birdAge = 2)