package solutions.shitops.advent.util

import org.scalatest.funsuite.AnyFunSuite

class ResourceReaderSuite extends AnyFunSuite {
  test("reading lines") {
    assert(
      ResourceReader.readLines("calorie-counting.input") ==
        List(
          "1000",
          "2000",
          "3000",
          "",
          "4000",
          "",
          "5000",
          "6000",
          "",
          "7000",
          "8000",
          "9000",
          "",
          "10000",
        ),
    )
  }

  test("reading string") {
    assert(
      ResourceReader.readString("calorie-counting.input") ==
        """1000
          |2000
          |3000
          |
          |4000
          |
          |5000
          |6000
          |
          |7000
          |8000
          |9000
          |
          |10000
          |""".stripMargin,
    )
  }
}
