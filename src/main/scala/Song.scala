class Song(title: String = "", author: String= "", lyrics:Seq[String]){

  println(s"New song $title made by $author")
  println(s"The song has ${lyrics.length} lines")


//  def sing():Unit={
//    println(s"$title, Author: $author")
//    for (line <- lyrics) println(line)
//
//  }

  def sing(maxLines: Int = -1):Unit = {
    println("-"*20)
    if (author != "") print(s"$author")
    if (title != "") print(s" - $title\n")
    println("-"*20)

    if ((maxLines == -1) || (maxLines > lyrics.length)) {
      for (line <- lyrics) {
        println(line)
      }
    } else {
      for (line <- lyrics.take(maxLines)) {
        println(line)
      }
    }
  }

  def yell(maxLines: Int = -1):Unit = {
    println("-"*20)
    if (author != "") print(s"$author")
    if (title != "") print(s" - $title\n")
    println("-"*20)

    if ((maxLines == -1) || (maxLines > lyrics.length)) {
      for (line <- lyrics) {
        println(line)
      }
    } else {
      for (line <- lyrics.take(maxLines)) {
        println(line.toUpperCase)
      }
    }
  }

}