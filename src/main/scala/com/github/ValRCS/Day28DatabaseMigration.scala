package com.github.ValRCS

object Day28DatabaseMigration extends App {

  val db = new NimDB("src/resources/nim/nim.db")

  db.migrate()

  db.insertResult("Alice", "Bob")

  //cleanup
  db.conn.close()

}
