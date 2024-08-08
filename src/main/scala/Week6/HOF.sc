/**Higher order functions (HOF) */

/* What does it mean to be a first class citizen? */

// We can:
// 1. Assign functions to vals
val addition:(Int, Int) => Int = (x, y) => x + y
addition(1, 2)
val subtract:(Int, Int) => Int = (x, y) => x - y

// 2. Store functions in collections (e.g. lists, maps, sequences, etc.)
// Below is a list that contains a list of different functions.
// Drawback is - not stored as names, but can be accessed using index.
val functionList = List(
  (a: Int, b: Int) => a + b,
  (a: Int, b: Int) => a * b,
  (a: Int, b: Int) => a - b
)
functionList.head(1,2) // access first function
functionList(1)(1,2) // second function ib index position 1
functionList(2)(1,2) // third function...

// 3. We can pass functions into arguments/params
def manipulateNumbers(x: Int, y: Int, function:(Int, Int) => Int): Int = {
  function(x,y)
}
manipulateNumbers(1,2, addition)
manipulateNumbers(1,2, subtract)

// 4. We can return functions from other functions
def createAdditionFunction(x: Int): Int => Int = {
//  println(s"$x")
  (y: Int) => x + y
}

createAdditionFunction(1)
val addOne: Int => Int = createAdditionFunction(1)
addOne(2)

/** Functions as params */
def firstHOF(x: Int, function: Int => Int): Int = {
  function(x)
}
def addTwo(n: Int): Int = n + 2
firstHOF(3, addTwo)
def square(n: Int): Int = n * n
firstHOF(3, square)

def processTheList(list1: List[String], function: String => String): List[String] = {
  list1.map(function)
}
def addS(word: String): String = word + "s"
def upperCase(word: String): String = word.toUpperCase
def lowerCase(word: String): String = word.toLowerCase
val newList: List[String] = List("apple", "banana", "pear", "mango")
processTheList(newList, addS)
processTheList(newList, upperCase)
processTheList(newList, lowerCase)

// map - common HOF
// iterating through a collection, and carrying out/performing an action (filter, filterNot, reduce etc.)
val numbers = Seq(1, 2, 3, 4, 5)
val doubledNumbers = numbers.map(num => num * 2)

/** foldLeft - used to reduce a collection into a single value
 * "Taking a collection and reducing it to a single value"
 */

val foldLeftExample = numbers.foldLeft(0)(_ + _) // (_ + _) -> The acc + current value - (acc + currentValue) SIMILAR TO RECURSION WHERE THE ACC IS BEING ADDED ON AS IT ITERATES!
//val foldLeftExample2 = numbers.foldLeft(0)(acc + value)
//val foldLeftExample3 = numbers.foldLeft(0)(totalNumber + value)

val stringsList = List("we", "love", "scala")
val concatenatedString = stringsList.foldLeft("")(_ + " " + _).trim() // trim to get rid of whitespaces!

// foldRight
val foldRightExample = numbers.foldRight(0)(_ + _)
val concatenatedStringRight = stringsList.foldRight("")(_ + " " + _).trim()

/** We can combine them with lists, case classes, for comprehension */

case class Male(male: Boolean)
case class Animal(name: String, male: Male)
val animalList = List(Animal("Fred the Fox", Male(true)), Animal("Sally the Seahorse", Male(false)), Animal("Lucky the Lion", Male(true)))

val foldAnimalsLeft = animalList.foldLeft(List[String]()) { (acc, animal) =>
  val sirOrMadam = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }
  acc :+ s"$sirOrMadam ${animal.name}"
}
println(foldAnimalsLeft)

val foldAnimalsRight = animalList.foldRight(List[String]()) { (animal, acc) =>
  val sirOrMadam = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }
  acc :+ s"$sirOrMadam ${animal.name}"
}
println(foldAnimalsRight)



/** Task 1 */
val productOfTheList = numbers.foldLeft(1)(_ * _)
val trueInts = numbers.filter(num => num % 2 == 0)

val numberOfCharacters = stringsList.foldLeft(0){ (acc, value) =>
  value.length + acc
}
val transformAndConcatenate = stringsList.foldLeft(""){ (acc, value) =>
  (acc + " " + value.capitalize).trim()
}
val transformAndConcatenateUsingMap = stringsList.map( word => (word.capitalize)).foldLeft("")(_ + " " + _).trim()


/** Returning functions */
  // each def is a mini HOF
def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.1
}

def mediumRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.2
}

def largeRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.5
}

case class Employee(name: String, salary: Double, lengthOfEmployment: Int)

def getPayRise(employee: Employee): (Int, Double) => Double = {
  employee.lengthOfEmployment match {
    // should be able to handle negative numbers or a 0 input maybe
    case year if (year <= 3) => smallRise(employee.salary)
    case year if (year <= 5) => mediumRise(employee.salary)
    case year if (year > 5) => largeRise(employee.salary)
  }
}

val Amanda: Employee = Employee("Amanda", 30000, 2)
val choosePayRise = getPayRise(Amanda)(2, 30000)
//val getNewSalary = choosePayRise(Amanda.lengthOfEmployment, Amanda.salary)