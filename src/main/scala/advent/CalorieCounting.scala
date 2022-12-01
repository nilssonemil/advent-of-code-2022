package solutions.shitops.advent

import scala.collection.mutable.ListBuffer
import scala.io.Source
import solutions.shitops.advent.util.ResourceReader

object CalorieCounting {

  case class Elf(val items: List[Int]) {
    def totalCalories = items.sum
  }

  def elves: List[Elf] = ResourceReader
    .readString("calorie-counting.input")
    .split("\n\n")
    .map(str => Elf(str.split("\n").map(_.toInt).toList))
    .toList

  def sortedElves = elves
    .map(_.totalCalories)
    .sorted(Ordering[Int].reverse)
  def max         = sortedElves.take(1).sum
  def topThreeSum = sortedElves.take(3).sum
}

@main def max() = println(f"Max calories: ${CalorieCounting.max}")
@main def sum() = println(f"Top three sum: ${CalorieCounting.topThreeSum}")
