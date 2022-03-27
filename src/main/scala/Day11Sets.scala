object Day11Sets extends App {
  println("The Scala set collections classes are an iterable collection with no duplicate elements")
  //https://docs.scala-lang.org/overviews/collections/overview.html
  // https://docs.scala-lang.org/overviews/collections/sets.html

  //USES:
  //removal of duplicates
  //quick membership testing
  //set theory operations, difference, union, etc

  val mySet = Set(3,6,1,6,1,3,2,7,9,2)
  println(mySet)
  val myNeedle = 7
  println(s"My needle $myNeedle exists in $mySet ? ${mySet(myNeedle)}")

  val anotherNeedle = 9000
  println(s"My needle $anotherNeedle exists in $mySet ? ${mySet(anotherNeedle)}")

  //membership tests like above should be extremely quick, in most cases it will constant time O(1)
  //even on very large sets

  //we can loop through sets (order is not guaranteed for HashSet)
  for (n <- mySet) {
    println(s"Item $n is in my set")
  }

  val arr = Array(0,1,7,3,2,3,2,7,8,9)
  println(arr.mkString(","))
  val setFromArray = arr.toSet
  println(setFromArray)
  //we could have used sorted set but those do not have the same performance as generic HashSet
  val arrFromSet = setFromArray.toArray.sorted //I also sort it at the time of conversion
  println(arrFromSet.mkString(","))


}
