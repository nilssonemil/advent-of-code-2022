package solutions.shitops.advent

import scala.collection.mutable.ListBuffer
import scala.io.Source
import solutions.shitops.advent.util.ResourceReader

object CalorieCounting {

  case class Elf(val index: Int, val items: List[Int]) {
    def totalCalories = items.foldLeft(0)(_ + _)
  }


  def elves: List[Elf] = {
    val entries : List[String] = ResourceReader.readLines("calorie-counting.input")
    var index = 1
    var elfs = new ListBuffer[Elf]()
    var next = Elf(index, List())

    for (entry <- entries) {
      if (entry == "") {
        elfs += next
        index += 1
        next = Elf(index, List())
      } else {
        next = Elf(next.index, next.items :+ entry.toInt)
      }
    }
    elfs += next // Poor last elf
    elfs.toList
  }

  def sortedElves = elves.map(_.totalCalories).sorted(Ordering[Int].reverse)
  def max = sortedElves.take(1).sum
  def topThreeSum = sortedElves.take(3).sum
}

@main def max() = println(f"Max calories: ${CalorieCounting.max}")
@main def sum() = println(f"Top three sum: ${CalorieCounting.topThreeSum}")
