package com.github.ValRCS

object Day21ReadingJSONwithUPickle extends App {
  val src = "src/resources/json/fruitFacts.json"

  val rawText = Util.getTextFromFile(src)
  println(rawText.take(100))

  //let's use uPickle library to parse the raw Text into some structure
  val data = ujson.read(rawText)
  println(data)
  //in order for arr method to work I need to know that my top level of data is actually an array (not an object or just a string or number)
  val arrData = data.arr.toArray
  println(arrData.head)
  println(arrData.last)

  //with o I indicate that it is an object
  val fruits = for (o <- arrData) yield {
    Fruit(o("genus").str,
      o("name").str,
      o("id").num.toInt,
      o("family").str,
      o("order").str,
      o("nutritions")("carbohydrates").num //so Double by default

    )
  }

  fruits.take(3).foreach(println)

}
