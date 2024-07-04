// Seq - no mixture inputs in Scala - only 1 type
val seq1: Seq[Int] = Seq(1, 2, 3)

// List
val list1: List[Int] = List(1, 2, 3)

/**
Map - takes 2 parameters
Key/Value pairs : key -> value
Needs to have a finite number of options
DOES NOT work with unlimited number of collections
 **/

val map1: Map[String, Int] = Map(
  "one" -> 1,
  "two" -> 2,
  "three" -> 3
)

val getSeqData: Int = seq1.head
// Tail will give everything in the sequence but the first element (in index position 0)
val getSeqTail = seq1.tail

val getListData: Int = list1(2)
val getListData: Int = list1.head
val getListData: List[Int] = list1.tail

val getMapData: Int = map1("one")

val tripledSeq: Seq[Int] = seq1.map {
  number => number * 3
}

val tripledList: List[Int] = list1.map {
  list => (list * 2) + 5
}

val tripledMap: Map[String, Int] = map1.map {
  case (key, value) => (key * 4, value * 3)
}

val changeKey: Map[String, Int] = map1.map {
  case (key, value) => (key + ".", value)
}

val changeKeyAndValue: Map[String, Int] = map1.map {
  case (key, value) => (key * 2, (value * 6) / 2)
}

// filter
val filteredSeq: Seq[Int] = seq1.filter (
  number => number > 2
)

val filteredList: List[Int] = list1.filter (
  number => number < 0
)

filteredSeq == filteredList

// tuple - [String, Int]
val filteredMap: Map[String, Int] = {
  map1.filter(number => number._2 > 1)
}

val filterNotList: List[Int] = list1.filterNot (
  number => number >= 2
)
// Any special characters within the curly brackets are recognised!

/**
 Exists
 Always returns a boolean
 We are checking if something exists within out sequence, list, or map
 As soon as it hits the first one that matches, it returns (won't bother going through the entire list after)
 */

val listExists: Boolean = list1.exists {
  number => number > 1
}

val seqExists: Boolean = seq1.exists {
  number => number > 1
}

// ._1 or ._2  tells the compiler where to look
val mapExists: Boolean = map1.exists {
  number => number._1 == "ones"
}

/**
 Contains
 only checks for 1 parameter
 */

val containsSeq: Boolean = seq1.contains(0)
val containsList: Boolean = list1.contains(0)

// For mapping and contains, it only checks for 'key' and not its 'value'
val containsMap: Boolean = map1.contains("one")

/**
 * Arrays
 */

val array1: Array[Int] = Array(1, 2, 3, 4)
val plusTwo: Array[Int] = array1.map {
  _ + 2
  }

/**
 * Append and Prepend
 */

var x = Seq[Int]()
x :+= 1
println(x)

val x = Seq[Int](2, 3, 4, 5)
val newX = 1 +: x :+ 6
val y = Seq[Int](8, 9, 10)
val newQ = x ++ y