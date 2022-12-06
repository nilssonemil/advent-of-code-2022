package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite
import solutions.shitops.advent.TuningTable._

class TuningTableSuite extends AnyFunSuite {

  test("first start of packet found") {
    assert(startOfPacketCompleted("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 7)
    assert(startOfPacketCompleted("bvwbjplbgvbhsrlpgdmjqwftvncz") == 5)
    assert(startOfPacketCompleted("nppdvjthqldpwncqszvftbrmjlhg") == 6)
    assert(startOfPacketCompleted("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 10)
    assert(startOfPacketCompleted("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 11)
  }

  test("first start of message found") {
    assert(startOfMessageCompleted("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 19)
    assert(startOfMessageCompleted("bvwbjplbgvbhsrlpgdmjqwftvncz") == 23)
    assert(startOfMessageCompleted("nppdvjthqldpwncqszvftbrmjlhg") == 23)
    assert(startOfMessageCompleted("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 29)
    assert(startOfMessageCompleted("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 26)
  }
}
