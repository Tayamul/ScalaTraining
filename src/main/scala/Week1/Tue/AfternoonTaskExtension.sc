/*
Extension Tasks
1. "STRING" == "string" = false, they're considered different strings as string comparisons are case-sensitive.

2. Can you convert "one" to 1.
Yes, you can if the value is initialised as var and the type is not defined. However, not defining a type makes the program vulnerable to errors.

3. Can you convert 1 to "one"
Yes, you can if the value is initialised as var and the type is not defined. However, not defining a type makes the program vulnerable to errors.

4. Can you convert 1 to a string.
Yes, you can if the value is initialised as var and the type is not defined. However, not defining a type makes the program vulnerable to errors.

5. Convert a lowercase string to uppercase.
Use a method .toUpperCase()

6. Convert on the first letter of a string to uppercase.
Use .charAt(0) method to highlight the first letter of the string
Use .toUpper method to convert it the upper case
Join the rest of the letters in the string
ALTERNATIVELY
Use the capitalize method
*/

"STRING" == "string"

var one = 1
var one = "string"

var str = "Hello World!"
var upperStr = str.toUpperCase()

var string = "elephant"
string.charAt(0).toUpper + string.substring(1)
string.capitalize

/*
Research Task
Make a val called new which is type string. Why doesn't this compile?
Naming a variable with a 'new' keyword is not acceptable because 'new' is a reserved keyword used for object instantiation. There are certain rules in Scala that the identifiers must follow, and using a reserved keyword violates these rules.

What do we need to do within our code to make it work?
To make the code work, we need to to use a different name, that is not a reserved keyword, to name variables. This ensures that the variable name adheres to Scala's identifier rules and does not conflict with language keywords.

Are there any other words that you cannot use?
There are several reserved keywords, such as throw, if, else, extends, case, def, true, false etc.
 */

//val new: String = "Youtube"