name := "bookexamples"

version := "1.0"
 
scalaVersion := "2.10.3"

EclipseKeys.withSource := true
 
resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8" % "test", 
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "com.typesafe.akka" %% "akka-testkit" % "2.2-M3",
  "com.typesafe.akka" %% "akka-actor" % "2.2-M3",
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test",
  "org.specs2" %% "specs2" % "2.1.1" % "test",
  "org.htmlparser" % "htmlparser" % "1.6",
  "org.scala-lang" % "scala-actors-migration" % "2.10.0-M4",
  "com.google.inject" % "guice" % "3.0",
  "org.json4s" %% "json4s-native" % "3.2.7"
)
