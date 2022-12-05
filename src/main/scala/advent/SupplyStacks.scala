package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader
import scala.collection.mutable.Stack

object SupplyStacks {
  val Array(crates, procedure) = ResourceReader
    .readString("supply-stacks.input")
    .split("\n\n")
  val lines                    = crates.split("\n")
  val idsLine                  = lines.last
  val ids                      = idsLine.trim.split("   ").map(_.toInt).toList
  val onlyCrates               = lines.dropRight(1).toList
  val indexes                  = idsLine.zipWithIndex
    .map((char, index) => {
      if (char.isWhitespace) {
        0
      } else {
        index
      }
    })
    .filterNot(_ == 0)
    .toList
  val stacks                   =
    for (index <- indexes)
      yield Stack[Char]().pushAll(
        onlyCrates
          .map(str => str(index))
          .filterNot(_.isWhitespace)
          .reverse
          .toList,
      )
  case class Move(from: Int, to: Int, amount: Int)
  val moves                    = procedure
    .split("\n")
    .map(line => {
      val Array(_, amount, __, from, ___, to) = line.split(" ")
      Move(from.toInt, to.toInt, amount.toInt)
    })
    .toList
  moves.foreach(move => {
    val from   = move.from - 1
    val to     = move.to - 1
    var toPush = Stack[Char]()
    1 to move.amount foreach { _ =>
      val popped = stacks(from).pop()
      toPush.push(popped)
    }
    toPush.foreach(stacks(to).push(_))
  })
  val tops                     = stacks.map(_.head).mkString
}

@main def tops = println(f"tops: \"${SupplyStacks.tops}\"")
