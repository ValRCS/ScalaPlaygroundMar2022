package com.github.ValRCS

class Flower(flowerType:String, val color:String) {
  println(s"Created a new flower of type: $flowerType with color $color")
  val flowerLength:Int  = flowerType.length
  //more methods here
  //more construction work here
  def save(dst:String=""):Unit = {
    //TODO actually save the flower!
  }

}

