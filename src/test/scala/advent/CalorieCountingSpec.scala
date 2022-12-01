package advent

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ListBuffer
import scala.io.Source

import advent.CalorieCounting._

class ColorieCountingSuite extends AnyFunSuite {
  
  test("Correct lines") {
    assert(
        read() == 
        List("1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000")
    )
  }


  test("elfs recognized") {
    val elfs = createElfList()

    assert(elfs == List(
      Elf(1, List(1000, 2000, 3000)),
      Elf(2, List(4000)),
      Elf(3, List(5000, 6000)),
      Elf(4, List(7000, 8000, 9000)),
      Elf(5, List(10000))))
  } 

  test("Total calories") {
    var elfs = createElfList()
    assert(
      elfs.map(e => List(e.index, e.totalCalories())).toList ==
      List(List(1, 6000), List(2, 4000), List(3, 11000), List(4, 24000), List(5, 10000))
    )
  }

  test("Found elf with most calories") {
    assert(elfMax == 24000)
  }

  test("sorted") {
    assert(
      createElfList().map(_.totalCalories()).sorted(Ordering[Int].reverse) == List(
        24000, 11000, 10000, 6000, 4000))
  }
}

