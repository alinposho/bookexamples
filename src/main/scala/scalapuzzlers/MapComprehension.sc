package scalapuzzlers

object MapComprehension {
  val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"), Seq("g", "h"), Seq("i", "j", "k"))
                                                  //> xs  : Seq[Seq[String]] = List(List(a, b, c), List(d, e, f), List(g, h), List
                                                  //| (i, j, k))

  val ys = for (Seq(x, y, z) <- xs) yield x + y + z
                                                  //> ys  : Seq[String] = List(abc, def, ijk)

  // The expression above gets translated into
  (xs filter { case Seq(_, _, _) => true; case _ => false}) map { case Seq(x, y, z) => x + y + z }
                                                  //> res0: Seq[String] = List(abc, def, ijk)
  // because we use pattern matching

  val zs = xs map { case Seq(x, y, z) => x + y + z }
                                                  //> scala.MatchError: List(g, h) (of class scala.collection.immutable.$colon$col
                                                  //| on)
                                                  //| 	at scalapuzzlers.MapComprehension$$anonfun$main$1$$anonfun$5.apply(scala
                                                  //| puzzlers.MapComprehension.scala:12)
                                                  //| 	at scalapuzzlers.MapComprehension$$anonfun$main$1$$anonfun$5.apply(scala
                                                  //| puzzlers.MapComprehension.scala:12)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike
                                                  //| .scala:244)
                                                  //| 	at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike
                                                  //| .scala:244)
                                                  //| 	at scala.collection.immutable.List.foreach(List.scala:318)
                                                  //| 	at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
                                                  //| 
                                                  //| 	at scala.collection.AbstractTraversable.map(Traversable.scala:105)
                                                  //| 	at scalapuzzlers.MapComprehension$$anonfun$main$1.apply$mcV$sp(scalapuzz
                                                  //| lers.MapComprehension.scala:12)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.work
                                                  //| Output exceeds cutoff limit.

}