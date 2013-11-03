name := "tdd-bowling-demo"

organization := "org.paradigma"

version := "0.0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.2" % "test"
)

initialCommands := "import org.paradigma.tddbowlingdemo._"

