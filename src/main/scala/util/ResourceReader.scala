package solutions.shitops
package util
import scala.io.Source

object ResourceReader {
  def readLines(filename: String) : List[String] =
    Source.fromResource(filename).getLines().toList
}
