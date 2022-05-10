package com.github.ValRCS

import java.nio.file.{Files, Paths}
import java.time.format.DateTimeFormatter
import java.time.{LocalDateTime, ZoneOffset, ZonedDateTime}
import java.util.Calendar

object Day27Persistence {
  //we could have also had the saveGameResult method made for Nim class which would be a fine choice
  def saveGameResult(dst:String, winner:String, loser:String) = {
    if (! Files.exists(Paths.get(dst))) {
      println("Saving header since no file exists")
      val header = "winner, loser, date" //we do not add \n since append will add \n
      Util.saveText(dst, header)
    } else {
      println(s"Need to save winner $winner and loser $loser")
      //TODO save above and also with the date
      //https://alvinalexander.com/scala/scala-get-current-date-time-hour-calendar-example/
      val now = Calendar.getInstance().getTime()
      println(s"Today is $now")
      val utcNow = ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT )
      //      println(LocalDateTime.now().format( DateTimeFormatter.ISO_INSTANT ))
      //TODO get local time in ISO 8601 format
      val row = s"$winner, $loser, $utcNow"
      Util.saveText(dst, row, true) //crucial that we use append flag so we do not accidentally overwrite..
      //TODO explore logging solutions such as infamous log4j which make saving similar date more structured
    }

  }
}
