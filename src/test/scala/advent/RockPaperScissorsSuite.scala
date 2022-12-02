package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite

import solutions.shitops.advent.util.ResourceReader

class RockPaperScissorsSuite extends AnyFunSuite {

  test("input is read ok") {
    assert(read == List("A Y", "B X", "C Z"))
  }

  test("input converted to game") {
    assert(games == List(Game(Rock, Draw), Game(Paper, Lose), Game(Scissors, Win)))
  }

  test("total score") {
    assert(score == 12)
  }
}
