package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite

import solutions.shitops.advent.TreeMap

class TreetopTreeHouseSuite extends AnyFunSuite {

  val treeMap = new TreeMap()

  test("input") {
    assert(treeMap.trees == List(
      List(3, 0, 3, 7, 3),
      List(2, 5, 5, 1, 2),
      List(6, 5, 3, 3, 2),
      List(3, 3, 5, 4, 9),
      List(3, 5, 3, 9, 0),
    ))
  }

  test("visible") {
    assert(treeMap.visibility == List(
      List(true, true, true, true, true),
      List(true, true, true, false, true),
      List(true, true, false, true, true),
      List(true, false, true, false, true),
      List(true, true, true, true, true),
    ))
  }

  test("sum") {
    assert(treeMap.visibleSum == 21)
  }

  test("scenic score 1,2") {
    assert(treeMap.scenicScore(2,1) == 4)
  }

  test("scenic score 2,3") {
    assert(treeMap.scenicScore(2,3) == 8)
  }

  test("max scenic score") {
    assert(treeMap.maxScenicScore == 8)
  }
}
