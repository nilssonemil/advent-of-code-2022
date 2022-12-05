package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite
import solutions.shitops.advent.util.ResourceReader

import scala.collection.mutable.Stack

class SupplyStacksSuite extends AnyFunSuite {
  test("assert tops") {
    assert(SupplyStacks.tops == "MCD")
  }
}
