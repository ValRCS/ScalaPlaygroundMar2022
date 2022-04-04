trait FlyingTrait {
  def fly(): Unit
}

trait RunningTrait {
  def run(speed:Int): Unit
  def topSpeed:Int = 90 //so it is a parameterless function that returns 90, this is more flexible than using val or var
  val strictLimit:Int = 120 //so normal field for whoever extends this Running Trait
  var flexibleLimit:Int = 50 //can be changed
}

trait SwimmingTrait {
  def swim(): Unit
  //so again if I fully define the function/method inside my trait I do not have to define it when I extend it
  def float(): Unit = {
    println("I am floating")
  }
}

class Penguin (val penguinName: String) extends SwimmingTrait with RunningTrait {
  def swim(): Unit = println(s"$penguinName can swim very swiftly")
  def run(speed:Int): Unit = println(s"$penguinName is running kinda funny")
}

//notice I am using chickenTopSpeed without var or val , that means I am not going to going to access it from outside
class Chicken (val chickenName: String, chickenTopSpeed:Int = 35) extends FlyingTrait with RunningTrait {
  def fly(): Unit = println(s"$chickenName can hardly fly away...")
  def run(speed:Int): Unit = {
    if (speed > topSpeed) {
      println(s"Wow! $chickenName can definitely run quite fast, at $speed km/h! more than $topSpeed")
    } else {
      println(s"$chickenName can definitely run quite fast, at $speed km/h! not quite $topSpeed")
    }
  }

  override def topSpeed: Int = {
    println(s"Doing fancy calculations for $chickenTopSpeed") // so this is a sideeffect now each time we want to see topSpeed
    chickenTopSpeed
  }
//  override val topSpeed: Int = chickenTopSpeed
//  override var topSpeed: Int = chickenTopSpeed //so all 3 are valid
  //last one lets us mutate
}

class Duck(val duckName: String) extends SwimmingTrait with FlyingTrait {
  def fly(): Unit = println("Look Duffy I am flying!")
  def swim(): Unit = println("Look at this ducky swim!")
  //we need to override a method that is already fully defined
  override def float(): Unit = println(s"Look $duckName is floating!")
}

object Day14ExerciseBirdsSolved extends App {
  println("Let's create some birds using traits!")

  val penguin1 = new Penguin("Claus")
  penguin1.swim()
  penguin1.run(25)
  println(penguin1.topSpeed) //here topSpeed is a method just very simple one without parameters that always returns 90
  val penguin2 = new Penguin("Bert")
  penguin2.swim()
  penguin2.float()


  val chicken1 = new Chicken("Henny", chickenTopSpeed = 33)
  chicken1.run(7)
  chicken1.topSpeed //will print but not return anything
  val chicken2 = new Chicken("Penny")
  chicken2.run(10)
  println(chicken2.topSpeed)
  println(s"Strict limit is ${chicken2.strictLimit}")
  println(s"Flex limit is ${chicken2.flexibleLimit}")
  chicken2.flexibleLimit += 25 // same as chicken2.flexibleLimit  = chicken2.flexibleLimit + 25
  //these two chicken objects do not share the same data once they hatched :)
  println(s"Flex limit for ${chicken2.chickenName} is ${chicken2.flexibleLimit}")
  println(s"Flex limit for ${chicken1.chickenName} is ${chicken1.flexibleLimit}")


  val duffy = new Duck("Duffy")
  duffy.fly()
  duffy.float()
  duffy.swim()
}
