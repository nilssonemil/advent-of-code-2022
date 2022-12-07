package solutions.shitops.advent

import org.scalatest.funsuite.AnyFunSuite

import solutions.shitops.advent.FileSystem
import solutions.shitops.advent.File
import solutions.shitops.advent.Directory
import solutions.shitops.advent.Day7

class Day7Suite extends AnyFunSuite {
  test("lists") {
    assert(
      Day7.directories.map(_.path).toList == List(
        "/",
        "/a/",
        "/a/e/",
        "/d/",
        )
      )
  }

  test("sum of < 100000") {
    assert(Day7.sum == 95437)
  }

  test("enough") {
    assert(Day7.enough == Some(24933642))
  }
  test("root looks good") {
    assert(
      Day7.fs.root == 
      Directory("/",
                List(File("b.txt", 14848514),
                     File("c.dat", 8504156)),
                List(Directory("/a/",
                               List(File("f", 29116),
                                    File("g", 2557),
                                    File("h.lst", 62596)),
                               List(Directory("/a/e/",
                                              List(File("i", 584)),
                                              List()))),
                     Directory("/d/",
                               List(File("j", 4060174),
                                    File("d.log", 8033020),
                                    File("d.ext", 5626152),
                                    File("k", 7214296)),
                               List())))
    )
  }
}
