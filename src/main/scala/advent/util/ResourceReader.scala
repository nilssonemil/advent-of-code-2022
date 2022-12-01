package solutions.shitops.advent.util

import scala.io.Source

object ResourceReader {
  def readLines(filename: String): List[String] =
    Source.fromResource(filename).getLines().toList

  def readString(filename: String): String =
    Source.fromResource(filename).mkString
}
