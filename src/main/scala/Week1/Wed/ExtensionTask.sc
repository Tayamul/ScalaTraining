/*
Scala Operator Precedence - from highest to lowest
Parentheses: (...)
Unary operators: +, -, !, ~
Exponentiation: **
Multiplicative operators: *, /, %
Additive operators: +, -
Bitwise shift operators: <<, >>, >>>
Relational operators: <, <=, >, >=
Equality operators: ==, !=
Bitwise AND: &
Bitwise XOR: ^
Bitwise OR: |
Logical AND: &&
Logical OR: ||
Assignment operators: =, +=, -=, *=, /=, %=, <<=, >>=, >>>=, &=, ^=, |=
 */

val task2 = true || false && false // true since the Logical AND has higher precedence than the Logical OR
val task3 = (true || false) && false // false since the parentheses has the highest level of precedence
val task4 = 1 < 4 && 7 != 10 || 9 + 10 == 21 // true

val int1: Int = 81
val int2: Int = 19

val result: String = if (int1 > int2) "yes" else "no"