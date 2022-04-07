package com.github.ValRCS

import scala.io.StdIn.readLine

object TreesAssignmentSolution extends App {
  //TODO ask person's name
  //TODO ask for tree height
  //TODO print a xmas tree (or another tree) by calling printTree function with the correct parameters
  //tree height should be the one assigned
  //simple version for height 3 would be
  //  *
  // ***
  //*****

  //for full points I would like to see the following
  //if user enters name Valdis  and height 9
  //then we should print
  //        *
  //       VVV
  //      AAAAA
  //     LLLLLLL
  //    DDDDDDDDD
  //   IIIIIIIIIII
  //  SSSSSSSSSSSSS
  // VVVVVVVVVVVVVVV
  //AAAAAAAAAAAAAAAAA

  //let's consider maximum height 40 (so person's name letters could repeat many times)

  def printTree(name: String, height: Int, symbol: Char = '*', maximumHeight: Int = 40): Unit = {
    //for this exercise we are not going to adjust maximumHeight
    println("Wrong printer!")
    //TODO print the tree HINT: check the last entry in Day7Strings
  }

  val name = readLine("Your Name: ")
  val xtreeTall = Math.round(readLine("Enter tree height not greeter then 40: ").toInt)

  if (xtreeTall < 1 || xtreeTall > 41) println("Maximum height exceeded. Please enter tree height lower then 40")

  else {

    def printTree(name: String, xtreeTall: Int, symbol: Char = '*', space: String = " ", max: Int = 40): Unit = {
      println(space * xtreeTall + symbol)
      for (n <- 1 until xtreeTall) println(space * (xtreeTall - n) + ((name * max) (n - 1)).toString * (n * 2 + 1))
    }

    //so while loop approach is much more prone to errors
    //why because we have to manually adjust index
    def printTreeAgain(personName: String, treeHeight: Int, topSymbol: Char = '*'): Unit = {
      if (treeHeight <= 40) {

        var symbol = 1
        var space = treeHeight
        println(" " * space + s"$topSymbol" * symbol)
        space -= 1;
        symbol += 2
        //so this is slight buggy so I create a new padded string with my name multiplied many times
        val myString = (personName * treeHeight).slice(0, treeHeight - 1)
        var i = 0
        while (i <= treeHeight - 2) {
          val c = myString(i)
          println(" " * space + s"$c" * symbol)
          i += 1;
          space -= 1;
          symbol += 2
        }

      } else {
        println(readLine(s"Dear $personName, sorry, this height $treeHeight is too long for survival," +
          s"please run programm again and choose height 40 as maximum"))

      }
    }

    printTree(name, xtreeTall) //this is the printTree defined inside our else
    printTreeAgain(name, xtreeTall)
  }
}
