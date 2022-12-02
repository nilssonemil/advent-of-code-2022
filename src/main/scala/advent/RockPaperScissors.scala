package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

sealed trait HandShape
case object Rock extends HandShape 
case object Paper extends HandShape
case object Scissors extends HandShape

case class Game(opponent: HandShape, me: HandShape) {
  def score = {
    val shape = me match {
      case Rock => 1
      case Paper => 2
      case Scissors => 3
    }
    val outcome = (me, opponent) match {
      case (me, opponent) if me == opponent => 3
      case (Rock, Scissors) => 6
      case (Paper, Rock) => 6
      case (Scissors, Paper) => 6
      case (_, __) => 0
    }
    shape + outcome
  }
}

def read = ResourceReader.readLines("rock-paper-scissors.input")
def games = read.map(str => {
  val Array(opponent, me) = str.split(" ")
  Game(opponent match {
    case "A" => Rock
    case "B" => Paper
    case "C" => Scissors
  },
  me match {
    case "X" => Rock
    case "Y" => Paper
    case "Z" => Scissors
  })
})

def score = games.map(_.score).sum

@main def totalScore = println(f"Score: $score")

