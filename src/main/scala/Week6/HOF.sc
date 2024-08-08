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
  println(s"$x")
  (y: Int) => x + y
}

createAdditionFunction(1)
val addOne: Int => Int = createAdditionFunction(1)
addOne(2)