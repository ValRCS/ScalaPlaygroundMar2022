import java.time.Year

object Day3AgeCalculator extends App {
  //TODO write an application that asks for person's and their age
  //Greet the person with their name
  //and calculate when they will be 100 years old and print it out
  //  val year = 2022 //this would be okay
  val year = Year.now.getValue //even better since the program would not break in 2023 :)

}
