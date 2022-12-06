package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

object RuckSackReorganization {
  def rucksacks  = ResourceReader.readLines("rucksack-reorganization.input")
  def itemsSplit = rucksacks
    .map(items => {
      val mid    = items.length / 2
      val first  = items.substring(0, mid)
      val second = items.substring(mid)
      (first, second)
    })
    .toList
  def common     = itemsSplit
    .map(items => {
      items(0).find(items(1).contains(_)).get
    })
    .toList
  def prios(l: List[Char]) = l
    .map(c => {
      val asDigit = c.toInt
      val value   =
        if (asDigit > (112 - 15)) asDigit - 96
        else asDigit - 38
      value
    })
    .toList
  def sum(l: List[Char])   = {
    prios(l).sum
  }

  def groups: List[List[String]] = rucksacks.grouped(3).toList
  def groupCommon                = groups
    .map(items => {
      items(0)
        .find(item => {
          items.slice(1, items.size).forall(_.contains(item))
        })
        .get
    })
    .toList
}

@main def rucksackSum      = println(
  f"sum: ${RuckSackReorganization.sum(RuckSackReorganization.common)}",
)
@main def rucksackGroupSum = println(
  f"group sum: ${RuckSackReorganization.sum(RuckSackReorganization.groupCommon)}",
)
