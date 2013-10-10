package scala.by.example.lists

object Prime {
	def isPrime(n: Int): Boolean = {
	  (2 to (n / 2)).forall(x => n % x != 0) 
	}
}