package com.github.ValRCS

import java.sql.{DriverManager, PreparedStatement, ResultSet}

class NimDB(val dbPath: String) {

  val url =  s"jdbc:sqlite:$dbPath"

  val conn = DriverManager.getConnection(url) //TODO handle exceptions at connection time
  println(s"Opened Database at ${conn.getMetaData.getURL}")

  /**
   * Perform table migration in a new installation, does nothing otherwise
   */
  def migrate():Unit = {
    //migrate for db refers to table creation other setup needed to start work in a new enviroment
    //https://www.sqlitetutorial.net/sqlite-create-table/
    val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

    //this query should do nothing if table already exists
    val sql =
      """
        |CREATE TABLE IF NOT EXISTS results (
        |id INTEGER PRIMARY KEY,
        |winner TEXT NOT NULL,
        |loser TEXT NOT NULL,
        |created TEXT
        |);
        |""".stripMargin

//    statement.executeQuery(sql) //so Query for selects
    statement.execute(sql)
  }

  def insertResult(winner:String,loser:String):Unit = {
    //we want to avoid inserting unprepared values
    //https://xkcd.com/327/

    //https://alvinalexander.com/source-code/scala-jdbc-sql-select-insert-statement-resultset-preparedstatement-example/

    val insertSql = """
                      |INSERT INTO results (winner,loser,created)
                      |values (?,?,"2022-05-12")
""".stripMargin
    //TODO fix the date later

    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)

    preparedStmt.setString (1, winner)
    preparedStmt.setString (2, loser)
    preparedStmt.execute

    preparedStmt.close()
  }

}
