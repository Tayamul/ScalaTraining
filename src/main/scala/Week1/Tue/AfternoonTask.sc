/* Task 1 */

val a = 3 + 4 * 57 < 300 // 232, therefore true
val b = 144 / 12 >= 12 // 12, therefore true
val c = "Cat" < "Dog" // alphabetically 'c' comes before 'd', therefore true
val d = "Rabbit" < "Hamster" // alphabetically 'r' comes after 'h', therefore false
val e = 17 % 2 != 0 // the remainder is 1 meaning the number 17 is odd, therefore true
val f = 75 / 9 < 30 && 89 / 6 < 20 // both calculations are true, therefore true

/*
Task 2 - Difference between a string and a print line.
Storing a value in a String variable makes the code more readable and maintainable. This allows developers to modify their functions with ease and helps other developers easily understand the logic behind the source code.
String returns a different type that println. String returns a string, where as println returns a unit.
*/

/*
Task 3
What is possible?
Values (vals) are immutable and a trustworthy source of code, whereas, variables (vars) are mutable and can be re-assigned as many times. However, having a variable with the same name twice is not recommended.

What isn't possible?
Once a data type is defined to a variable, you cannot re-assign the variable with a different type. You get a 'type mismatch' error.

Something that's strange.
Initially, I thought comparing two strings meant the program was comparing their lengths and returning a boolean value. However, that's not the case. The program compares each letter of the strings alphabetically and returns a value based on which letter comes first (or last).
*/