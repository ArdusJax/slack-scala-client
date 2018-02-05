name := "slack-scala-client"
version := "0.4.0"
scalaVersion := "2.12.4"
//crossScalaVersion ++=Seq("2.11.11", "2.12.3")

libraryDependencies ++=Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.19",
  "com.typesafe.akka" %% "akka-http-core" % "10.0.10",
  "org.scala-lang.modules" %% "scala-async" % "0.9.6",
  "com.typesafe.play" %% "play-json" % "2.6.3",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xlint", "-Xfatal-warnings", "-feature")
