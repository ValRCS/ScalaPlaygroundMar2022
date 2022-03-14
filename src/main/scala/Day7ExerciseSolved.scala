object Day7ExerciseSolved extends App {
  def processString(text:String, uppercaseChars:String ="", needsTrim:Boolean=false):String = {
    //TODO first trim string if it needs trimming from the argument
    //TODO replace All characters in uppercaseChars with their uppercase versions
    //you will need to write a loop
    //you will probably want to use var to store a temporary string that you keep reweriting
    //return newly created string

    var newString = "" //so I start with an empty string and build it up
    //this approach with an empty string is completely fine on smaller strings say a few hundred characters long
    //it will get slow to add a new character to the end of a large string
    //for that we need to use a StringBuilder which is optimized for concatenation operations
    //https://www.baeldung.com/scala/stringbuilder //TODO check it out
    for (c <- text){
      if (uppercaseChars.contains(c)) {
        newString += c.toUpper
      } else {
        newString += c
      }
    }
    newString
  }

  println(processString("abracadabra", "cr")) //should print abRaCadabRa
  println(processString("   abracadabra  ", "cr", needsTrim = true)) //should print abRaCadabRa
}
