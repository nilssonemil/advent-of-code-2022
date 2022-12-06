package solutions.shitops.advent

import solutions.shitops.advent.util.ResourceReader

object TuningTable {

  def datastream = ResourceReader.readString("tuning-table.input")

  private def firstRepeatedPosition(datastream: String, timesRepeated: Int): Int =
    datastream.sliding(timesRepeated, 1).toList.map(_.toSet.size == timesRepeated).indexOf(true) + timesRepeated

  def startOfPacketCompleted(datastream: String) = firstRepeatedPosition(datastream, 4)
  def startOfMessageCompleted(datastream: String) = firstRepeatedPosition(datastream, 14)
}

@main def startOfPacketMarker = println(f"start of packet: ${TuningTable.startOfPacketCompleted(TuningTable.datastream)}")
@main def startOfMessageMarker = println(f"start of message: ${TuningTable.startOfMessageCompleted(TuningTable.datastream)}")
