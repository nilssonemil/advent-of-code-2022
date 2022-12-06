package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite
import solutions.shitops.advent.TuningTable._

class TuningTableSuite extends AnyFunSuite {

  test("first start of packet found") {
    assert(startOfPacketMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 7)
    assert(startOfPacketMarker("bvwbjplbgvbhsrlpgdmjqwftvncz") == 5)
    assert(startOfPacketMarker("nppdvjthqldpwncqszvftbrmjlhg") == 6)
    assert(startOfPacketMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 10)
    assert(startOfPacketMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 11)
  }

  test("first start of message found") {
    assert(startOfMessageMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 19)
    assert(startOfMessageMarker("bvwbjplbgvbhsrlpgdmjqwftvncz") == 23)
    assert(startOfMessageMarker("nppdvjthqldpwncqszvftbrmjlhg") == 23)
    assert(startOfMessageMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 29)
    assert(startOfMessageMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 26)
  }
}
