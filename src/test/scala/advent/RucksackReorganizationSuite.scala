package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite

class RucksackReorganizationSuite extends AnyFunSuite {

  test("read first item") {
    assert(rucksacks(0) == "vJrwpWtwJgWrhcsFMMfFFhFp")
  }

  test("strings in two halfs") {
    assert(itemsSplit(0) == ("vJrwpWtwJgWr", "hcsFMMfFFhFp"))
  }

  test("common item") {
    assert(common(0) == 'p')
  }

  test("prio for item") {
    assert(prios(common)(0) == 16)
  }

  test("sum") {
    assert(sum(common) == 157)
  }

  test("groups") {
    assert(groups == List(
      List(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg"),
      List(
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw"),
      )
    )
  }

  test("group common") {
    assert(groupCommon == List('r', 'Z'))
  }

  test("priorities grouped") {
    assert(prios(groupCommon) == List(18, 52))
  }

  test("sum of grouped") {
    assert(sum(groupCommon) == 70)
  }
}
