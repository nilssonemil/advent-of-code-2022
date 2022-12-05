package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader
import scala.collection.mutable.Stack

object SupplyStacks {
  case class Move(from: Int, to: Int, amount: Int)
  class Stacks(drawing: String) {
    val lines   = drawing.split("\n")
    val indexes = lines.last.zipWithIndex
      .map((char, index) => if (char.isWhitespace) 0 else index)
      .filterNot(_ == 0)
      .toList
    val crates  = lines.dropRight(1).toList
    val stacks  =
      for (index <- indexes)
        yield Stack[Char]().pushAll(
          crates.map(str => str(index)).filterNot(_.isWhitespace).reverse.toList,
        )

    def moveCrates(move: Move) = {
      val from   = move.from - 1
      val to     = move.to - 1
      var toPush = Stack[Char]()
      1 to move.amount foreach { _ =>
        val popped = stacks(from).pop()
        toPush.push(popped)
      }
      toPush.foreach(stacks(to).push(_))
    }

    def tops = stacks.map(_.head).mkString
  }

  val Array(drawing, procedure) = ResourceReader
    .readString("supply-stacks.input")
    .split("\n\n")
  val stacks                    = Stacks(drawing)
  val moves                     = procedure
    .split("\n")
    .map(line => {
      val Array(_, amount, __, from, ___, to) = line.split(" ")
      Move(from.toInt, to.toInt, amount.toInt)
    })
    .toList

  def tops = {
    moves.foreach(stacks.moveCrates(_))
    stacks.tops
  }
}

@main def tops = println(f"tops: \"${SupplyStacks.tops}\"")
