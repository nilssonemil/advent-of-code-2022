package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

object CampCleanup {
  def ranges = ResourceReader
    .readLines("camp-cleanup.input")
    .map(_.split(",").toList)
    .map(
      _.map(_.split("-").toList)
        .map(bounds => bounds(0).toInt to bounds(1).toInt)
        .toList,
    )

  def fullyContained = ranges
    .filter(ranges => {
      val first  = ranges(0).toSet
      val second = ranges(1).toSet
      first.subsetOf(second) || second.subsetOf(first)
    })
    .toList

  def overlapping = ranges
    .filter(ranges => ranges(0).exists(ranges(1).contains))
    .toList
}

@main def fullyContained = println(
  f"Pairs with range fully contained: ${CampCleanup.fullyContained.length}",
)
@main def overlapping    = println(
  f"Pairs with overlap: ${CampCleanup.overlapping.length}",
)
