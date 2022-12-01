package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ListBuffer
import scala.io.Source

import solutions.shitops.advent.CalorieCounting._

class ColorieCountingSuite extends AnyFunSuite {

  test("elfs recognized") {
    assert(
      elves == List(
        Elf(List(1000, 2000, 3000)),
        Elf(List(4000)),
        Elf(List(5000, 6000)),
        Elf(List(7000, 8000, 9000)),
        Elf(List(10000)),
      ),
    )
  }

  test("Total calories") {
    assert(elves.map(_.totalCalories) == List(6000, 4000, 11000, 24000, 10000))
  }

  test("Found elf with most calories") {
    assert(max == 24000)
  }

  test("sorted falling") {
    assert(sortedElves == List(24000, 11000, 10000, 6000, 4000))
  }

  test("top three") {
    assert(sortedElves.take(3) == List(24000, 11000, 10000))
  }

  test("top three sum") {
    assert(topThreeSum == 45000)
  }
}
