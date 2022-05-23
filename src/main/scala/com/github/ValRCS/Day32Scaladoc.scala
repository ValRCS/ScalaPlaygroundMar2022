package com.github.ValRCS

/**
 * object for holding day 32 examples
 * @author Valdis Saulespurens
 * @version 1.0.0
 * @see [[https://semver.org/]] on how semantic versioning works
 */
object Day32Scaladoc extends App {
  //https://docs.scala-lang.org/style/scaladoc.html
  //https://alvinalexander.com/scala/scaladoc-syntax-tags-wiki-formatting-examples/

  /**
   * returns sum of two integers a and b
   * @param a
   * @param b
   * @return
   */
  def add(a:Int, b:Int): Int = a+b

  /**
   * returns the largest of two parameters
   * @param a
   * @param b
   * @return
   * @example {{{val myMax = Day32Scaladoc.max(7, 12)}}}
   */
  def max(a:Int, b:Int): Int = if (a > b) a else b

  println(s"2+2=${add(2,2)}")
}
