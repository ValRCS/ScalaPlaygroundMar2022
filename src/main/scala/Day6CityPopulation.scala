object Day6CityPopulation extends App {
  //easy function
  //TODO write a function (name it yourself) to calculate Farenheit from Celsius
  //f = 32 + c*9/5

  //test it with 36.6
  //test it with 37
  //test it with 48.5

  //TODO 2nd main TASK - not really related to first task
  println("Function to calculate city growth")
  //TODO write a function getCityYear which takes the following 4 parameters
  //p0: Int - how many people are in beginning
  //perc: Int - yearly growth rate in percentages
  //delta: Int - how many people immigrate(+)/emigrate to the city each year
  //targetPopulation: Int - population we want to reach

  //we want to return the year city will reach targetPopulation
  //or we return -1 if the city will NEVER reach the population
  //it is a little bit tricky because we do not want to use return statements
  //we want to return the last line only
  //so you probably want to use some variable to hold the result
  //you will need a loop - while probably
  //you will need some if else statements
  //if we write comments /**
  //those are so called ScalaDoc style comments and they can be used by automatic tools to create documentation

  // */

  /**
   * getCityYear
   * @param p0 - original City population
   * @param percentage - yearly growth rate in percentages
   * @param delta - how many people immigrate(+)/emigrate to the city each year
   * @param targetPopulation - population we want to reach
   * @return number of years to reach , -1 if not reachable
   */
  def getCityYear(p0: Int, percentage: Double, delta: Int, targetPopulation: Int):Int = {
    //add some code here....
    9000 //FIXME //right now it returns this 9000 all the time
  }

  println(getCityYear(1000,2,50,1200)) // should print 3
  println(getCityYear(1000,2,-50,1200)) // should print -1
  println(getCityYear(1500000,2.5,10000,2000000)) // should print 10
}
