name := "scala-test1"

version := "0.1"

scalaVersion := "2.12.8"

lazy val akkaVersion = "2.5.22"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",

  "org.apache.spark" % "spark-streaming_2.10" % "1.6.2" % "provided",
  "org.apache.spark" %% "spark-core" % "1.6.2" % "provided",
  "org.apache.spark" %% "spark-sql" % "1.6.2" % "provided",
  "org.apache.spark" % "spark-streaming-kafka_2.10" % "1.6.2" //注意版本
)
