package com.github.ValRCS

import java.sql.{DriverManager, PreparedStatement, ResultSet}

class NimDB(val dbPath: String) {

  val url =  s"jdbc:sqlite:$dbPath"

  val conn = DriverManager.getConnection(url) //TODO handle exceptions at connection time
  println(s"Opened Database at ${conn.getMetaData.getURL}")

  def dropAllTables():Unit = {
    val statement = conn.createStatement()
    val sql =
      """
        |DROP TABLE IF EXISTS results;
        |""".stripMargin
    val sql2 =
      """
        |DROP TABLE IF EXISTS scores;
        |""".stripMargin
    val sql3 =
      """
        |DROP TABLE IF EXISTS users;
        |""".stripMargin
    statement.addBatch(sql)
    statement.addBatch(sql2)
    statement.addBatch(sql3)
    statement.executeBatch()  //more efficient than 3 single queries
  }

  /**
   * Perform table migration in a new installation, does nothing otherwise
   */
  def migrate():Unit = {
    //migrate for db refers to table creation other setup needed to start work in a new enviroment
    //https://www.sqlitetutorial.net/sqlite-create-table/

    //TODO created multiple tables with users in one table
    //so when we do insert we will reference the users table in our results table

    val statement = conn.createStatement() //we create a statement object that will handl sending SQL statements to the DB

    //this query should do nothing if table already exists
    //this query should do nothing if table already exists
    val sql0 =
    """
      |CREATE TABLE IF NOT EXISTS users (
      |id INTEGER PRIMARY KEY,
      |name TEXT NOT NULL,
      |email TEXT,
      |created TEXT
      |);
      |""".stripMargin

    //    statement.executeQuery(sql) //so Query for selects
    //    statement.execute(sql)
    statement.addBatch(sql0)

    val sql =
      """
        |CREATE TABLE IF NOT EXISTS results (
        |id INTEGER PRIMARY KEY,
        |winner INTEGER NOT NULL,
        |loser INTEGER NOT NULL,
        |created TEXT,
        |    FOREIGN KEY (winner)
        |       REFERENCES users (id),
        |   FOREIGN KEY (loser)
        |       REFERENCES users (id)
        |);
        |""".stripMargin

//    statement.executeQuery(sql) //so Query for selects
//    statement.execute(sql)
    statement.addBatch(sql)
    //TODO add another sql statement that creates scores table if it does not exist
    //this table should have the following columns
    //id, game_id, turn, move, created
    //id is the primary key
    //it should have game_id column that will be referencing our results table - so called Foreign Key
    //also it should have turn column that will store game turn (starting from 1) for a specific game
    //finally we store move column
    //also lets store a created column as well -this will use autamtic timestamp later
    val sql2 =
    """
      |CREATE TABLE IF NOT EXISTS scores (
      |id INTEGER PRIMARY KEY,
      |game_id INTEGER NOT NULL,
      |turn INTEGER NOT NULL,
      |move INTEGER NOT NULL,
      |created TEXT,
      |    FOREIGN KEY (game_id)
      |       REFERENCES results (id)
      |);
      |""".stripMargin

//    statement.execute(sql2)
    statement.addBatch(sql2)
    statement.executeBatch()

  }

  def insertResult(winner:String,loser:String):Unit = {
    //we want to avoid inserting unprepared values
    //https://xkcd.com/327/

    //https://alvinalexander.com/source-code/scala-jdbc-sql-select-insert-statement-resultset-preparedstatement-example/

    val insertSql = """
                      |INSERT INTO results (winner,loser,created)
                      |values (?,?,CURRENT_TIMESTAMP)
""".stripMargin
    //CURRENT_TIMESTAMP is in SQL standard: https://stackoverflow.com/questions/15473325/inserting-current-date-and-time-in-sqlite-database

    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)

    preparedStmt.setString (1, winner)
    preparedStmt.setString (2, loser)
    preparedStmt.execute

    preparedStmt.close()
  }

  //TODO create insertScore method
  //parameters will be Array[Int] of moves
  //also we will want a reference to the game id

  //TODO we need to create a helper method to get the id of the last game played in results
  def getIdOfLastGame():Int = {
    val statement = conn.createStatement()
//    val sql =
//      """
//        |SELECT id FROM results
//        |WHERE id=(SELECT max(id) FROM results);
//        |""".stripMargin
    val sql =
        """
          |SELECT MAX(id) id FROM results;
          |""".stripMargin
    val resultSet = statement.executeQuery(sql)
    val lastGameId = resultSet.getInt("id")
    lastGameId
  }
  //this assumes we save the game result first
  //https://stackoverflow.com/questions/5191503/how-to-select-the-last-record-of-a-table-in-sql
  //so we we will store moves for all games in a single table,
  //id, game_id, turn, move, created
  //1, 1, 1, 3, 2022-05-12etc
  //2, 1, 2, 2, 2022
  //...
  //8, 2, 1, 3, 2022
  //9, 2, 2, 1, 2022
  //10, 2, 3, 2, 2022
  //
  def insertScore(game_id: Int, turn: Int, moves: Int): Unit = {
      val insertSql = """
                        |INSERT INTO scores (game_id,turn,move,created)
                        |values (?,?,?,CURRENT_TIMESTAMP)
  """.stripMargin

      val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)

      preparedStmt.setInt(1, game_id)
      preparedStmt.setInt(2, turn)
      preparedStmt.setInt(3, moves)

      preparedStmt.execute

      preparedStmt.close()
  }

  def insertFullScore(moves:Array[Int]):Unit = {
    val id = getIdOfLastGame()
    for ((move, turn) <- moves.zipWithIndex) {
      insertScore(id, turn, move)
    }
  }

}
