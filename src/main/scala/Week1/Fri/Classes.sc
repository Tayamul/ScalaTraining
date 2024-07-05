/**
 * Classes
 * Declare using 'class'
 * Capital for the name
 * Acts as blueprints
 *
 *
 *
 */

// First way - unimplemented members
class ThemeParkEmptyParams (val hasRollerCoasters: Boolean, val diameterOfLargestLoop: Double)

// Second way - implement members
// {} braces instead of parentheses
// default params should be provided

class ThemeParkDefaultParams {
  val hasRollerCoasters: Boolean = true
  val diameterOfLargestLoop: Double = 30.24
}

// Everything inside the {} belongs to that class. Known as members (attributes) of the class.

class ThemeParkBoth (val diameterOfLargestLoop: Double) {
  val hasRollerCoasters: Boolean = true
}


/**
 * Objects
 * Use classes to make objects
 * Capital word
 */

// Empty Params
val mercatorPark: ThemeParkEmptyParams = new ThemeParkEmptyParams(hasRollerCoasters = true, diameterOfLargestLoop = 7.95)
mercatorPark.getClass
mercatorPark.hasRollerCoasters

// Default Params
val disneyWorld: ThemeParkDefaultParams = new ThemeParkDefaultParams()
disneyWorld.diameterOfLargestLoop

/**
 * Parameters
 * Give a meaningful name
 * We can pass in raw values, or existing vals can be passed in
 */

class Hamster (age: Int, val colour: String)
val orange: String = "Orange"
// Make the Hamster object
val BooTheHamster: Hamster = new Hamster(1, orange)

/**
 * Objects without classes
 * Use when only need 1 of something
 * Don't require to the use 'new' keyword
 * Have no params
 * Available globally (imports available)
 */

object DavidsDogs {
  val Loki: String = "Loki"
  val Tayamul: String = "Tayamul"
  val Isla: String = "Isla"
  val Bilal: String = "Bilal"
  val Oscar: String = "Oscar"
}

DavidsDogs.Loki

/**
 * Inheritance
 * Use the 'extends' keyword
 * Declare the class we want to extend
 * The class we extend from is called the parent/superclass
 * Can only extend ONE class
 */

//class Bakken extends ThemeParkDefaultParams {
//  override val diameterOfLargestLoop: Double = 20.15
//  val oldestThemePark: Boolean = true
//}

class Bakken extends ThemeParkEmptyParams (hasRollerCoasters = true, diameterOfLargestLoop = 20.15) {
  val oldestThemePark: Boolean = true
}

/**
 * Traits
 * Keyword is 'with'
 * We can extend multiple traits
 * Traits can have unimplemented members
 * We cannot create an instance of a trait (like we can on a class)
 * We can use in combination with something else
 */

trait Mascot {
  val nameOfMainCharacter: String
}

trait OversizedFood {
  val hugeTurkeyLeg: Boolean
}

class DisneyWorld extends ThemeParkDefaultParams with Mascot with OversizedFood {
  override val nameOfMainCharacter: String = "Micky"
  override val hugeTurkeyLeg: Boolean = true
}
