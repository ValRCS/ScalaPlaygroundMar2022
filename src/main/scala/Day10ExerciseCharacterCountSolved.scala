import scala.io.StdIn.readLine

object Day10ExerciseCharacterCountSolved extends App {
  val text = readLine("Please enter any text or sentence: ")

  //two approaches usually seen
  //we will use a mutable Map
  val charCount = scala.collection.mutable.Map[Char,Int]() //so empty Map with type Char -> Int mapping
  //so we just need to loop through the text and count the characters

  for (c <- text) { //c is what i named individual character in my text for the looping purposes
    println(s"Will do something with the character $c")
//    charCount += (c -> text.count(t => t == c))
    charCount += (c -> text.count(_ == c)) //shorter version of above _ refers to single char in text
  }
 //c stops existing here

  //will this work and will this be fast?
  println(charCount)
  //this is a solution but it is not the best solution

  //what do you think is the problem with this solution?
  //the only problem is that each time we count we have to run a loop through all the text,
  //so we end up doing quadratic work, meaning loop withing a loop

  //there is a better solution where we only need a single loop
  //think of throwing things in boxes when you organize stuff around the house
  //we are going to set a box for each letter and just throw the letters in






}
