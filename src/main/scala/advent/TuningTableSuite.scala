package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

object TuningTable {

  def startOfPacketMarker(str: String): Int = {
    str.sliding(4, 1).toList.map(_.toSet.size == 4).indexOf(true) + 4
  }

  def startOfMessageMarker(str: String): Int = {
    str.sliding(14, 1).toList.map(_.toSet.size == 14).indexOf(true) + 14
  }

  def getPacketStart = startOfPacketMarker(ResourceReader.readString("tuning-table.input"))
  def getMessageStart = startOfMessageMarker(ResourceReader.readString("tuning-table.input"))
}

@main def startOfPacketMarker = println(f"start of packet: ${TuningTable.getPacketStart}")
@main def startOfMessageMarker = println(f"start of packet: ${TuningTable.getMessageStart}")
