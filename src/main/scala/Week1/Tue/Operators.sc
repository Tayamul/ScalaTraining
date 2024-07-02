/*
Arithmetic Operators
addition (a+b)
subtraction (a-b)
multiplication (a*b)
division (a/b)
modulus (a%b) finds the remainder
 */

val a: Int = 10
val b: Int = 5
val c: Int = 3

val add = a + b + c
val subtract = a - b
val multiply = b * c
val divide = a / c // why is it 3?
val modulus = a % c

/*
Relational
Compare 2 booleans
== (Equality)
!= (Inequality)
< (less than)
<= (less than or equal to)
> (greater than)
>= (greater than or equal to)
 */

val equality = a == b
val inequality = a != b
val lessThan = a < b
val lessThanOrEqualTo = a <= b
val greaterThan = a > b
val greaterThanOrEqualTo = a >= b

/*
Logical
Combine boolean
 */

val and = true && false // both needs to be true to return true
val or = true || false // only one needs to be true to return true
val not = !true // NOT true == false

/*
Task 1
Logical AND
true && true = true
true && false = false
false & true = false
false * false = false

Logical OR
true || true = true
true || false = true
false || true = true
false || false = false

Logical NOT
!true = false
!false = true
 */

val result = false || false

/* Task 2 */

val a = 4 + 3 * 55 < 300 // true
val b = 96 / 12 >= 8 // true
val c1 = "Hamster"
val c2 = "Hippo"
val cResult = c1 < c2 // false - compares alphabetically - 'a' comes before 'i'
val d = 8 % 2 == 0 // true as the remainder returned is 0
val e = 156 / 8 < 20 && 54 < 20 && 54 / 4 < 14 // false