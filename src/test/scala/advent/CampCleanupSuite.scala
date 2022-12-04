package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite

import solutions.shitops.advent.util.ResourceReader
import solutions.shitops.advent.CampCleanup._

class CampCleanupSuite extends AnyFunSuite {

  test("fullyContained") {
    assert(fullyContained == List(
      List(2 to 8, 3 to 7),
      List(6 to 6, 4 to 6),
      ))
  }

  test("overlaps") {
    assert(overlapping == List(
      List(5 to 7, 7 to 9),
      List(2 to 8, 3 to 7),
      List(6 to 6, 4 to 6),
      List(2 to 6, 4 to 8),
      ))
  }
}
