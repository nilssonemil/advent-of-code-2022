package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

case class File(name: String, size: Int)
class Directory(
    val path: String,
    var files: List[File] = List(),
    var children: List[Directory] = List(),
) {
  def addDirectory(path: String): Directory       =
    children.find(path contains _.path) match {
      case Some(directory) => directory.addDirectory(path)
      case None            => {
        val directory = new Directory(path)
        children = children :+ directory
        directory
      }
    }
  def addFile(file: File, filePath: String): File = {
    if (path == filePath) {
      files = files :+ file
      file
    } else {
      children.find(filePath contains _.path) match {
        case Some(directory) => directory.addFile(file, filePath)
      }
    }
  }
  def size: Int         = children.map(_.size).sum + files.map(_.size).sum
  override def toString = s"Directory($path,$files,$children)"
  def canEqual(a: Any)  = a.isInstanceOf[Directory]
  override def equals(other: Any): Boolean =
    other match {
      case other: Directory => {
        other.canEqual(this) &&
        this.path == other.path &&
        this.files == other.files &&
        this.children == other.children
      }
      case _                => false
    }
}

class FileSystem {
  var root                     = new Directory("/")
  private var currentDirectory = "/"

  def changeDirectory(directory: String) =
    directory match {
      case "/"       => root = new Directory("/")
      case ".."      => {
        val index  = currentDirectory.dropRight(1).lastIndexOf("/")
        val newDir = currentDirectory splitAt index
        val derp   = newDir.head + "/"
        currentDirectory = derp
      }
      case directory => currentDirectory = currentDirectory + directory + "/"
    }

  def updateFiles(data: List[String]) = {
    data.map(_.split(" ") match {
      case Array("dir", name)        =>
        root.addDirectory(currentDirectory + name + "/")
      case Array(fileSize, fileName) =>
        root.addFile(File(fileName, fileSize.toInt), currentDirectory)
    })
  }
}

object Day7 {

  val fs    = new FileSystem()
  val files = ResourceReader
    .readString("no-space-left-on-device.input")
    .split("\\$ ")
    .drop(1)
    .foreach(exec => {
      val command :: data = exec.split("\n").toList
      command match {
        case x if x.startsWith("cd ") => fs.changeDirectory(x.substring(3))
        case "ls"                     => fs.updateFiles(data)
      }
    })

  def flatten(directory: Directory): List[Directory] =
    if (directory.children == List()) return List(directory)
    return List(directory) ::: directory.children.map(flatten(_)).flatten

  val directories: List[Directory] = flatten(fs.root)
  val sum          = directories.map(_.size).filter(_ < 100000).sum
  val spaceToFree  = fs.root.size - (70000000 - 30000000)
  val sortedBySize = directories.map(_.size).sorted
  val enough       = sortedBySize.find(size => size > spaceToFree)
}

@main def sumStuff = println(f"sum: ${Day7.sum}")
@main def enough   = println(f"enough: ${Day7.enough}")
