package com.github.ValRCS.SpringProject
import com.github.ValRCS //so this lets us use ValRCS and then whateaver we need
//Above to me seems like best compromise between length and namespace collisions
//import com.github.ValRCS.{Flower, Person}
//I can rename whatever I am importing if I have a naming conflict
//import com.github.ValRCS.{Flower => MyFlower, Person => MyPerson}
//import com.github.ValRCS._  //This gets me everything from my package but it is not recommended
//because we may pollute the global namespace with something that we made


object Day16HelloSpring extends App {
  println("I have a new project in Spring!")
  val snowFlower = new ValRCS.Flower("snowFlower","white")
  //below full syntax also works
//  val snowFlower = new com.github.ValRCS.Flower("snowFlower","white")
//  val snowFlower = new MyFlower("snowFlower","white")
  println(snowFlower.color)
  //again for case class no need for new
  val sister = ValRCS.Person("Nora","sister", 170)
//  val sister = MyPerson("Nora","sister", 170)
  println(sister)
}
