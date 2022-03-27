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

  //alternative syntax for membership testing
  println(mySet(myNeedle), mySet contains myNeedle) //same thing

  //while using immutable sets, just like with other immutables I will need to create a new set
  val setWithAddition = mySet + 100 //100 should be added to the set (not math add!)
  println(setWithAddition)
  val setWithMultipleAdditions = setWithAddition + (2,100,300,150)
  println(setWithMultipleAdditions)
  val setAfterRemoval = setWithMultipleAdditions - 9 //9 should be removed from our collection
  println(setAfterRemoval)
  println(setAfterRemoval - 9) //so no exception on removing something that does not exist
  val setAfterMultipleRemovals = setAfterRemoval - (1,2,5,9,100) //we are removing that items that do not exist which is fine
  println(setAfterMultipleRemovals)
  //so recommendation now for set difference is to actually declare real set
  val setAgainAfterMultipleRemovals = setAfterRemoval -- Set(1,2,5,9,100) //we are removing that items that do not exist which is fine
  println(setAgainAfterMultipleRemovals)

  //we can also have mutable Sets
  val mutSet = scala.collection.mutable.Set[Int]() //so we start with an empyt mutable Set
  println(mutSet)
  mutSet += 5
  mutSet += 3
  mutSet += 5
  println(mutSet) //should see 3 and 5 here
  mutSet ++= (0 to 10).toArray //so 3 and 5 is already there so those will stay
  println(mutSet)
  mutSet ++= Array(9000,9001,5,9000) //again only new unique values will be added
  println(mutSet)
  mutSet.add(10) //so just like +=
  mutSet.add(15)
  println(mutSet) //only 15 should be added since 10 already existed
  mutSet -= 7
  mutSet.remove(2) //same idea as previous line with -=
  println(mutSet)
  println(s"Size of mutSet at the moment is ${mutSet.size}")
  mutSet.clear
  println(s"Size of mutSet at the moment is ${mutSet.size}")
  println(mutSet)

  //we saw how we can add and remove items to sets next step will be to explore some operations from set theory



}
