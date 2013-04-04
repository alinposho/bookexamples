//// This will not work unless the scalacheck jar is added to the build path.

//package chapter14.tests.propertybased
//
//import chapter10.puttingitalltogether.Element.elem
//import org.scalatest.prop.Checkers
////import org.scalacheck.Prop._
//import org.junit.runner.RunWith
//import org.scalatest.WordSpec
//import org.scalatest.junit.JUnitRunner
//
//@RunWith(classOf[JUnitRunner])
//class ElementSpec extends WordSpec with Checkers {
//
//  "elem result" must {
//    "have passed width" in {
//      check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
//    }
//    "have passed height" in {
//      check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
//    }
//  }
//}