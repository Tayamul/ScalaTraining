// Task 1 - Starting with a Seq(1-9), come up with 2 filters that, when used together, will return Seq (1,2,5,7).
val seq1: Seq[Int] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)

val filterOne: Seq[Int] = seq1.filter(_ < 3)
val filterTwo: Seq[Int] = seq1.filter(
//  num => (num % 2 !=0) && num < 9 && num > 3
  num => num == 5 || num == 7
)


val combinedTogether: Seq[Int] = filterOne ++ filterTwo

// Task 2 - The head function returns the first element of a list, and the tail function returns everything except the first element. Use head and tail only to get the 3rd element of a List.


val list1: List[Int] = seq1.toList
val thirdElement: Int = list1.tail.tail.head

/**
 * Research task
 * Set is unordered and cannot have duplicate elements, whereas, Seq is ordered and can contain duplicate elements.

 * Order:
 * Seq: An ordered collection of elements. The order of elements in a Seq is maintained, meaning that the position of each element is fixed.
 * Set: An unordered collection of unique elements. The order of elements in a Set is not guaranteed, and it does not store duplicate elements.

 * Uniqueness:
 * Seq: Allows duplicate elements. You can have the same element appearing multiple times at different positions in the sequence.
 * Set: Ensures that all elements are unique. If you try to add a duplicate element to a set, it will be ignored.

 * Common Operations:
 * Seq: Common operations include accessing elements by index (apply), appending elements (:+, ++), and other sequence-like operations.
 * Set: Common operations include checking for membership (contains), adding/removing elements (+, -), and set operations like union, intersection, and difference.
 *
 */

Set(1,2) == Set(2,1,1,1) // true, because it ignores duplicate elements and the order does not matter. What matters is the presence of unique elements.

List(3, 4) == Seq(3, 4) // true, because a List is a subtype of Seq and since the elements in both sequences are equal and ordered.

List(5, 6) == Set(5, 6) // false, because they are both a different type of collection. Additionally, a List consists of an ordered sequence that allows duplicates, and a Set is an unordered collection of unique elements. The comparison checks if they are the same type of collection and contain the same elements in the same order, which they do not.