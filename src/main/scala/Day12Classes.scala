/**
 * the most simple class definition we can have in scala
 * not very useful by itself
 */
class PlainHouse

/**
 * Describes a blueprint for a generic House
 * @param name - House name
 * @param levels - how many stories are in the house
 */
class House(var name:String, val levels:Int, var material:String = "Brick") {
  //constructor block - meaning it will run when an object is created from this class blueprint
  println("Starting construction!")
  //inside the constructor we put the things we want done upon initalization

  //method is a function that lives inside our object
  def prettyPrint():Unit = {
    //unlike many other languages we do not need to use this or self to access our internal data
    println(s"Cool our house is called $name and it has $levels stories and it is made of $material")
  }

  //we can change the default functionality of what we get when we try to print our objects created from this class
  //toString is specific we cant choose another name
  //in other words we override already existing definition
  //this is not required but can be done for convenience
  override def toString: String = {
    s"Neat our house is called $name and it has $levels stories and it is made of $material"
  }
}


object Day12Classes extends App {
  println("Classes as blueprints for objects")
  println("Objects hold data and methods to work with data")
  //https://docs.scala-lang.org/overviews/scala-book/classes.html

  val myPlainHouse = new PlainHouse //this creates an object instances out of PlainHouse blueprint
  println(myPlainHouse)
  val anotherPlainHouse = new PlainHouse //this is a second object out of our PlainHouse class blueprint
  println(anotherPlainHouse)

  val myHouse = new House("countryHouse", 2)
  myHouse.prettyPrint()
  println(myHouse)
  println(myHouse.name) //we can GET values/fields/data out of objects using dot notation
  println(myHouse.levels)
  //we can change the name because we defined with var
  myHouse.name = "myCountryCastle" // i can SET fields if they were defined in the blueprint with var
  println(myHouse.name)

  //i create another object out of House class blueprint
  val anotherHouse = new House("cityHouse", 5)
  anotherHouse.prettyPrint()

  val strawHouse = new House("piggieHouse", 1, "Straw")
  strawHouse.prettyPrint
  println(strawHouse)

  //members
  //fields
  //methods
  //public vs private


}
