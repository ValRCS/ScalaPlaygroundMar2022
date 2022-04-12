package com.github.ValRCS

import scala.io.Source

object Day17FileReadingSolution extends App {
  //TODO read stopping by poem from src/resources/stopping_by.txt
  //TODO get poem name - it is the first line
  //TODO get poet - it is in the 2nd line but we want just the poet

  //TODO Get all lines which contain "woods" somewhere in the text
  //so instead of startsWith we use contains

  //relative path
  val filePath = "src/resources/stopping_by.txt"

  val bufferedSource = Source.fromFile(filePath)
  val myLines = bufferedSource.getLines().toArray
  bufferedSource.close()

  val poemName = myLines.head //this is Scala style, also could use text(0)
  println(s"Poem name: $poemName\n")

  // One method:
  val poetName = myLines(1).drop(3)

  // Another method:
  val lengthOfSecondLine:Int = myLines(1).length
//  val poetName = text(1).slice(3,lengthOfSecondLine) //so we slice from 4th character to the end
  println(s"Poet name: $poetName\n")

//  val poetNames = myLines(1).split(" ") //so here I split by single whitespace
  val poetNames = myLines(1).split(" +") //so this was real regex I said I want to split by 1 or more whitespace
  println(poetNames.mkString("|"))
  //we would need to check if we got anything meaning
  val middleName = poetNames(1) //so 2nd word in the 2nd line
  println(s"Poet's first name is: $middleName")


  val woodsLines = for (line <- myLines if line.contains("woods")) yield line
  println("Lines with the word 'woods':\n")
  woodsLines.foreach(println)

  //alternative way to filter what we need
  val woodLines = myLines.filter(_.contains("woods")).map(_.toUpperCase)
  woodLines.foreach(println)

}
