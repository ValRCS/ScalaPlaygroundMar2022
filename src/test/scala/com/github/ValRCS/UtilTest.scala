package com.github.ValRCS

import org.scalatest.funsuite.AnyFunSuite

class UtilTest extends AnyFunSuite {
  test("Util.myRound") {
    //TODO write some tests
    assert(Util.myRound(3.14, 0) === 3.0) //checking double/float equality can be tricky
    assert(Util.myRound(3.14159, 2) === 3.14)
    assert(Util.myRound(3.14159, 4) === 3.1416)
  }

  test("Util.myRound.zeros") {
    assert(Util.myRound(0.0041, 0) === 0.0)
  }

  test("Util.myRound.negative") {
    assert(Util.myRound(-1.52, 0) === -2.0)
  }

  test("Util.getCharacterCount") {
    val arr = Array("Valdis", "Scala") //so 11 characters plus newline between so answer should be 12
    assert(Util.getCharacterCount(arr) === 12)
  }

  test("Util.getCharacterCount.blank") {
    val arr = Array[String]()
    assert(Util.getCharacterCount(arr) === 0)
  }

  //TODO write 2 more tests for util methods, you can pick whichever method you want to test
  //test one method at a time

  test("getWordCountPerLine"){
    val arr = Array("My name is Yana", "Today is a good day for some unit tests")
    assert(Util.getWordCountPerLine(arr) === Array(4,9))
  }

  test("getWordCountPerLine.blank"){
    val arr = Array[String]()
    assert(Util.getWordCountPerLine(arr) === Array())
  }

}
