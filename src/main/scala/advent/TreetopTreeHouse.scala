package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

class TreeMap {
    val trees: List[List[Int]] = ResourceReader.readLines("treetop-tree-house.input").map(_.toList.map(_.asDigit).toList).toList

    def row(y: Int): List[Int] = trees(y)
    def column(x: Int): List[Int] = trees.map(_(x)).toList
    def isVisible(x: Int, y: Int) = {
      val height = trees(y)(x)
      val (leftOf, _::rightOf) = row(y) splitAt x
      val (above, _::under) = column(x) splitAt y
      val leftVisible = leftOf.forall(_ < height)
      val rightVisible = rightOf.forall(_ < height)
      val aboveVisible = above.forall(_ < height)
      val underVisible = under.forall(_ < height)
      leftOf.forall(_ < height) || rightOf.forall(_ < height) || above.forall(_ < height) || under.forall(_ < height)
    }

    def visibility = 
      val ySize = trees.length
      val xSize = trees(0).length
      for (x <- List.range(0, xSize)) yield for (y <- List.range(0, ySize)) yield isVisible(x, y)

    def visibleSum = visibility.flatten.count(_ == true)

    def scenicScore(x: Int, y: Int): Int =
      val height = trees(y)(x)
      val (left, _::right) = row(y) splitAt x
      val (above, _::under) = column(x) splitAt y

      val aboveBlockingDistance = distance(above.reverse, height)
      val underBlockingDistance = distance(under, height)
      val leftBlockingDistance = distance(left.reverse, height)
      val rightBlockingDistance = distance(right, height)
      aboveBlockingDistance * underBlockingDistance * leftBlockingDistance * rightBlockingDistance

    def distance(trees: List[Int], height: Int): Int =
      trees.indexWhere(_ >= height) match {
        case -1 => trees.length
        case index => index + 1
      }

    def maxScenicScore = 
      val ySize = trees.length
      val xSize = trees(0).length
      val scenicScores = for (x <- List.range(0, xSize)) yield for (y <- List.range(0, ySize)) yield scenicScore(x, y)
      scenicScores.flatten.max
  }

@main def visibleTrees =
  val treeMap = new TreeMap()
  println(s"visible trees = ${treeMap.visibleSum}")


@main def scenicScore =
  val treeMap = new TreeMap()
  println(s"scenic score = ${treeMap.maxScenicScore}")
