/*
 Functions and Method
 Functions
 Assigned to a val
 also methods
 no different to any other type
 don't have to name them (however if we don't, they aren't reusable)

 Methods
 keyword 'def'
 Belong to a class
 can be overridden
 must be named

def nameOfMethod (parameters, but this can be empty): ReturnType = {
<expression 1>
<n number of expressions>
<last expression results in a value that is of the same type as the ReturnType>
}

 */

// Anonymous function
(number: Int) => number + 1

// Named function
val addition = (number: Int) => number  + 1

// Method (also a function)
def addition = (number: Int) => number  + 1

// Override Method
def addition = (number: Int) => number  + 10

// Example method
def makeACupOfTea (numOfSugars: Int): String = {
  s"You have made a tea with $numOfSugars spoons of sugar. Enjoy!"
}

// Call a method
makeACupOfTea(2)

/**
 * Task 1
 * We never see the last expression being a println(). Why do you think it is?
 * Because the method always returns. Println() returns a unit type. AVOID RETURNING 'UNIT' TYPE AT ALL COSTS!
 */

/**
 * VAT method - SOLID principle in mind, each function and method should have a single purpose. Modular!!
 */
val vat: Double = 1.2
def priceWithVAT(price: Double): Double = {
  price * vat
}

priceWithVAT(5)

/** Methods within a class */
class Number(num:Int){
  def addition(aDifferentNum: Int): Int = {
    num + aDifferentNum
  }
}

val newNumberClass = new Number(10)
val classAddition = newNumberClass.addition(7)

/** Task 1 */
def getBigVal(input1: Int, input2: Int): String = {
  if (input1 > input2) "first"
  else if (input1 < input2) "second"
  else if (input1 == input2) "same"
  else "Not valid"
}

getBigVal(3, 1)

/** Task 2 */
def nameLength(firstName: String, surname: String): Int = {
  if (firstName.length > surname.length) firstName.length
  else if (firstName.length < surname.length) surname.length
  else if (firstName.length == surname.length) 0
  else 404 // Can use 'eithers' as the best substitution
}

nameLength("Chris", "Pratt")

/** Pure and Impure Functions
 * ALWAYS aim for pure functions.
 * Scala wants immutability.
 * */
/** PURE */
val sentence: String = ""
def append(sentence:String, word: String): String = {
  sentence + "" + word.trim() // takes off any whitespace
}
val a = append(sentence, "hello")
val b = append(sentence, "hello")

/** IMPURE */
var sentence: String = ""
def append1( word: String): String = {
  sentence = sentence + " " + word.trim()
  sentence.trim() // trimming to get rid of empty space
}
val c = append1("hello")
val d = append1("world")