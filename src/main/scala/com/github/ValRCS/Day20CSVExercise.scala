package com.github.ValRCS

object Day20CSVExercise extends App {

  val src = "src/resources/csv/fruitvegprices-19apr22.csv"

  //TODO get the top 5 most expensive apple entries
  //TODO get the least expensive 5 apple entries

  //TODO get average price for lettuce

  //TODO get cherry tomatoes pricing min, max, mean for year 2022

  //TODO extra credit challenge get average price for lettuce by year

  //two approaches - one is simply hardcode starting and ending years and filter by those
  //you might not even need to extract year simply lexicographical filering should work

  //even better approach use groupBy
  // hint: use groupBy but first you would need to modify case class with Year field(value)
  //alternative to creating a Year entry would be to split date field while grouping and group by first portion
  // https://alvinalexander.com/scala/how-to-split-sequences-subsets-groupby-partition-scala-cookbook/
}
