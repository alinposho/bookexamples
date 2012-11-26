package chapter4

class ChecksumAccumulator {
	private var sum = 0;
	
	def add(b: Byte): Unit = sum += b
	def checkSum(): Int = ~(sum & 0xFF) + 1
}