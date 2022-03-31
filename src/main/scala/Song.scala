class Song(title: String = "", author: String= "", lyrics:Seq[String]){

  println(s"New song $title made by $author")
  println(s"The song has ${lyrics.length} lines")


//  def sing():Unit={
//    println(s"$title, Author: $author")
//    for (line <- lyrics) println(line)
//
//  }

  //internal utility function
  private def printLyrics(lines:Seq[String], maxLines: Int = -1):Unit = {
    if ((maxLines == -1) || (maxLines > lyrics.length)) {
      for (line <- lines) {
        println(line)
      }
    } else {
      for (line <- lines.take(maxLines)) {
        println(line)
      }
    }
  }

  //private unless we want to allow outside use of this function
  private def printTitle():Unit = {
    println("-"*20)
    if (author != "") print(s"$author")
    if (title != "") print(s" - $title\n")
    println("-"*20)
  }

  def sing(maxLines: Int = -1):Unit = {
    printTitle()
    printLyrics(lyrics, maxLines) //sometimes these pass along chains can get too long 3 or 4 functions deep
  }

  def yell(maxLines: Int = -1):Unit = {
    printTitle()
    val capitalLyrics = lyrics.map(_.toUpperCase)
    printLyrics(capitalLyrics, maxLines)
  }

  //it is now trivial to add a similar whisper function
  def whisper(maxLines: Int = -1):Unit = {
    printTitle()
    val capitalLyrics = lyrics.map(_.toLowerCase)
    printLyrics(capitalLyrics, maxLines)
  }

}