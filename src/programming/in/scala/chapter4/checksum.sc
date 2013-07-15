package chapter4

object checksum {

	val acc = new ChecksumAccumulator         //> acc  : chapter4.ChecksumAccumulator = chapter4.ChecksumAccumulator@11d4c3d5
	acc.add(8)
	acc.checkSum                              //> res0: Int = -8




}