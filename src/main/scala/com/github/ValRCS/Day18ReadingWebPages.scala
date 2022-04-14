package com.github.ValRCS

object Day18ReadingWebPages extends App {
  val url = "https://www.gutenberg.org/files/61262/61262-0.txt"
  val text = Util.getTextFromWeb(url) //we make a get request on the web resource
  println(text.take(300))
  val dst = "src/resources/ChristieA_Poirot_Investigates.txt"
  Util.saveText(dst, text)
}
