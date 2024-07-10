/*
Class is just a blueprint, a guide, a set of instructions.
 */

/**
 * With parentheses ()
 * Construct with no defined parameters
 */
class Park1
// instantiating an object
new Park1

/**
 * Construct with defined parameters
 * We are not giving default values
 * We do not have to put val/var (best practice to include)
 */
class Park2(val rollerCoaster: Boolean, largestLoop: Double)
// Making an object
new Park2(rollerCoaster = true, largestLoop = 3.16)
new Park2(rollerCoaster = false, largestLoop = 4.2)

// Extend Park2 Class - must enter values because I don't have defaults
object Disney extends Park2 (rollerCoaster = true, largestLoop = 23.6)

/**
 * Abstract - if we are not giving default values but are giving defined parameters, we might as make it abstract.
 * By making it abstract - acts as a safety net
 * It forces the developer to add values a lot sooner because it won't compile without them.
 * They work in a similar ways to traits
 * WE DON'T CHANGE THE ABSTRACT CLASS, INSTEAD, WE EXTEND FROM IT, AND THEN INSTANTIATE AN OBJECT AFTER.
 */
abstract class Park3 (coaster: Boolean, loop: Double)
// Making an object - is not possible!
//new Park3 // CAN'T TO THIS!
// MUST BE EXTENDED IN ORDER TO USE THEM!!

/**
 * Constructing with default parameters
 * Things that are unlikely to change
 * Remain the same for the entire child of the parent class
 */
class Park4 (val coaster: Boolean = true, val loop: Double = 4.7)
// Make an object
new Park4() // would use default values
/// do not need to use the keyword override or val/var
// can override none, 1, multiple params
// if not overriding, do not include it
new Park4(coaster = false) // can override the existing default value | using default for loop but has a override for coaster


/** With curly braces {} */

// No defined parameters
class Park5 {}
// Make an object
new Park5

// Constructed with defined parameters (but not default values) -- NOPE, can't do this!
// Either make it abstract, or make it default
/*
class Park6 {

  val coaster: Boolean
  val loop: Double
}
*/

//abstract class Park6 {
//  val coaster: Boolean
//  val loop: Double
//}

// Constructed with default parameters
// New line {   }
// Must declare the params as a val or var
class Park7 {
  val coaster: Boolean = true
  val loop: Double = 5.6
}
// Making an object
new Park7 // use of default params
// Can override these
val y = new Park7 {
  override val coaster: Boolean = false
}

// We can extend Park7
object LegoLand extends Park7 {}
LegoLand.loop
// Override
object LegoLand2 extends Park7 {
  override val loop: Double = 3.5
}
LegoLand2.loop

/**
 * Abstract classes - {} less fussy way to deal with abstract
 * Acts as a SAFETY NET!
*/
// must use val / var
abstract class Park8 {
  val coaster: Boolean
  val loop: Double
}
// Make an object
// short-hand - type in Park8 and wait for the pop-up
new Park8 {
  val coaster: Boolean = true
  val loop: Double = 6.32
}
// When extending - must give a value to every parameter (even if it has a default param - safety net)
object HydePark extends Park8 {
  override val coaster: Boolean = false
  override val loop: Double = 0.0
}

/**
 * Abstract with ()
 * Cannot instantiate an object from abstract class with parentheses
 * MUST extend it to be able to instantiate it!
 * */
abstract class Park9 (val coaster: Boolean, val loop: Double)
// Make an object
new Park9() // NOPE!
// When we extend the class, we can make an object!
object AnotherNewPark extends Park9(true, loop = 5.14)
AnotherNewPark.coaster
AnotherNewPark.loop

/**
 * What os accessible?
 * Will lose access to parameters if you remove val / var from abstract class with ()
 */
AnotherNewPark.coaster


/** Both () AND {} */
class Park10 (val coaster: Boolean) {
  val loop: Double = 7.6
}
new Park10 (coaster = true)
// With an abstract class, must re-declare all the variables to be able to instantiate it.
abstract class Park10 (val coaster: Boolean) {
  val loop: Double = 7.6
}
new Park10 (coaster = false) {
  override val loop: Double = 9.76
}


/**
 * TRAITS
 * no good on their own
 * need to inherit
 */

// without defaults
trait CandyFloss {
  val hasCandyFloss: Boolean
}
object AnotherNewPark2 extends CandyFloss {
  override val hasCandyFloss: Boolean = true
}

// with default value
trait CandyFloss2 {
  val hasCandyFloss: Boolean = true
}
object AnotherNewPark3 extends CandyFloss2 {
  override val hasCandyFloss: Boolean = false
}

/**
 * Traits and abstract classes is used to be extended! (used in the same way)
 * No limits on how many traits we can extend, whereas, only 1 class can be extended!
 * Abstract classes give us more safety!
 */


/**
 * Sealed keyword
 * Only access in the same file (scope matters)
 * The scope gets dramatically reduced if we add 'sealed'
 * Adds safety and security
 * Allows for exhaustive matching?? (to be continued...)
 */
sealed abstract class AbstractClassThatIsSealed
sealed trait SealedTrait
