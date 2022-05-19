package com.github.ValRCS

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class NimDBTest extends AnyFunSuite  with BeforeAndAfter {

  var nimDB: NimDB = _

  before {
    println("Setup Up Before tests")
    //even better would be to create a specific database just for testing
    //here we are testing on production database which might not be desirable
    //on the other hand we know that the production database works after tests run :)
    nimDB = new NimDB("src/resources/nim/test.db")
    nimDB.dropTables() //so we drop all relevant tables
    nimDB.migrate()
  }



  test("NimDBTest.testUnknownPlayer") {
    val playerId = nimDB.getUserId("ThisUserShouldNotExist")
    assert(playerId === 0)
  }

  test("NimDBTest.insertNewPlayer") {
    val player = Player("testPlayer")
    val playerId = nimDB.insertNewUser(player.name)
    assert(playerId > 0)

  }

  test("NimDBTest.insertScore") {
    nimDB.insertScore(1,4,2)
    //TODO we would need to have a method tocheck for this insertion
    assert(0 === 0 ) //TODO add actual test
  }
}
