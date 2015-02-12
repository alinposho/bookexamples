package javaconcurrency

object blahTest {
  val b = new JavaBlah(199)                       //> b  : javaconcurrency.JavaBlah = javaconcurrency.JavaBlah@1815a349
  
  b.getField()                                    //> res0: Int = 199
  b.getInner()                                    //> res1: javaconcurrency.JavaBlah#InnerBlah = javaconcurrency.JavaBlah$InnerBla
                                                  //| h@45a270b2
  // Look at the type of c
  val c = b.getList()                             //> c  : java.util.List[_] = []
  
}