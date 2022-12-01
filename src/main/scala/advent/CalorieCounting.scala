package advent

import scala.collection.mutable.ListBuffer
import scala.io.Source

//@main def elfMax() = println(f"Max calories: ${CalorieCounting.elfMax}")
object CalorieCounting {

  def read() = 
      Source.fromResource("calorie-counting.input").getLines().toList

  case class Elf(val index: Int, val items: List[Int]) {
    def totalCalories() = items.foldLeft(0)(_ + _)
  }

  def createElfList() = {
    val entries : List[String] = read()
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

  def elfMax = createElfList().map(_.totalCalories()).max
  def sortedElfs = createElfList().map(_.totalCalories()).sorted(Ordering[Int].reverse)
}

@main def elfTopThree() =
  val topThree = CalorieCounting.sortedElfs.take(3)
  val sum = topThree.sum

  println(f"Top three: $topThree sum: $sum")
