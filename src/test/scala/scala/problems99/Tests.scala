package scala.problems99

import org.junit.runner.RunWith
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Tests extends WordSpec
  with MustMatchers {

  "extract" must {
    "extract the characters and shrink balanced intervals" in {
      assert(extract("(ab)".toSeq.toVector) === Vector.empty) 

      assert(extract("(ab".toSeq.toVector) === Vector('a', 'b'))

      assert(extract("(ab)c".toSeq.toVector) === Vector('c')) 

      assert(extract("(ab(c(d))e".toSeq.toVector) === Vector('a', 'b', 'e'))
    }
  }

}