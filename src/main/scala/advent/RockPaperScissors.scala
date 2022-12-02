package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

sealed trait HandShape
case object Rock     extends HandShape
case object Paper    extends HandShape
case object Scissors extends HandShape

sealed trait Outcome
case object Win  extends Outcome
case object Lose extends Outcome
case object Draw extends Outcome

case class Game(opponent: HandShape, outcome: Outcome) {

  private def handshape(desired: Outcome, opponent: HandShape): HandShape =
    (desired, opponent) match {
      case (Win, Rock)      => Paper
      case (Win, Paper)     => Scissors
      case (Win, Scissors)  => Rock
      case (Draw, opponent) => opponent
      case (Lose, Rock)     => Scissors
      case (Lose, Paper)    => Rock
      case (Lose, Scissors) => Paper
    }

  def score = {
    val me           = handshape(outcome, opponent)
    val shapeScore   = me match {
      case Rock     => 1
      case Paper    => 2
      case Scissors => 3
    }
    val outcomeScore = outcome match {
      case Win  => 6
      case Draw => 3
      case Lose => 0
    }
    shapeScore + outcomeScore
  }
}

def read  = ResourceReader.readLines("rock-paper-scissors.input")
def games = read.map(str => {
  val Array(opponent, me) = str.split(" ")
  Game(
    opponent match {
      case "A" => Rock
      case "B" => Paper
      case "C" => Scissors
    },
    me match {
      case "X" => Lose
      case "Y" => Draw
      case "Z" => Win
    },
  )
})

def score = games.map(_.score).sum

@main def totalScore = println(f"Score: $score")
