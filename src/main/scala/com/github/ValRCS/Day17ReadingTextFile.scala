package com.github.ValRCS

import scala.io.Source

object Day17ReadingTextFile extends App {
  println("Let's read some text files!")

  //let's check our current working directory because we need to know to have correct relative path

  println(System.getProperty("user.dir"))

  //using Absolute Path first
  // Windows uses \ for separating folders - unfortunately \ is also used to escape some character \n \t
  // One solution would be to escape those \ -> \\
  val filePath = "C:\\Users\\val-wd\\IdeaProjects\\ScalaPlaygroundMar2022\\src\\resources\\two_roads.txt"

  //print all characters one by one
//  for (character <- Source.fromFile(filePath)) println(character) //turns out we just read a big string of characters...

  //print lines one by one
//  for (line <- Source.fromFile(filePath).getLines) println(line) //we want to read lines of text not single characters

  //we could save the whole file into a String
  val myPoem = Source.fromFile(filePath).mkString //so we turn a stream of characters into one big String

  println(myPoem)

  val myPoemLines = Source.fromFile(filePath).getLines.toArray //toArray because iterator was on demand lazy

  println("*"*40)
  println("Printing Poem line by line \n")

  for (line <- myPoemLines) println(line)




  //one catch is that file remains open until the our program finishes running
  //TODO see how to close a file on longer programs

}
