package programming.in.scala

object typeRefinement {

  class Entity {
    def persistForReal() = ()
  }

  trait Persister {
    def doPersist(e: Entity) = {
      e.persistForReal()
    }
  }

  // our refined instance (and type):
  val refinedMockPersister = new Persister {
    override def doPersist(e: Entity) = ()
  }                                               //> refinedMockPersister  : programming.in.scala.typeRefinement.Persister = prog
                                                  //| ramming.in.scala.typeRefinement$$anonfun$main$1$$anon$1@6879c0f4

  trait SimplestContainer {
    type A // Abstract Type Member

    //def value: A
  }
  
  val c = new SimplestContainer {}                //> c  : programming.in.scala.typeRefinement.SimplestContainer = programming.in.
                                                  //| scala.typeRefinement$$anonfun$main$1$$anon$2@48a95008
  //c.value
}