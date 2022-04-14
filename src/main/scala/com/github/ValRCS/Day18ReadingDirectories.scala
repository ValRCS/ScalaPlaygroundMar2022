package com.github.ValRCS

object Day18ReadingDirectories extends App {
  val src = "src/resources"
  val files = Util.getListOfFiles(src)
  files.foreach(println)
  println("Just the woods files please")
  val woodsFiles = Util.getListOfFiles(src, regex = "^D*.") //FIXME regex
  woodsFiles.foreach(println)

  println(s"Is ${files.head} there? ${Util.isFileTHere(files.head.toString)}")
  val badFilePath = "notAFile.txt"
  println(s"Is ${badFilePath} there? ${Util.isFileTHere(badFilePath)}")
  val readMePath = "README.md"
  println(s"Is ${readMePath} there? ${Util.isFileTHere(readMePath)}")

  val lines = Util.getLinesFromFile(files.head.toString)
  val wordCountPerLine = Util.getWordCountPerLine(lines)

  val wordCount = wordCountPerLine.sum
  println(s"Total words in ${files.head.toString} are $wordCount")
  val avgCount = wordCount*1.0 / lines.length
  val roundedCount = Util.myRound(avgCount, 2)
  println(s"Average word count in each line is $avgCount")
  println(s"Average word count in each line is $roundedCount")
}
