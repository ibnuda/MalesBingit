name := "MalesBingit"

version := "1.0"

lazy val `malesbingit` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc ,
  anorm ,
  cache ,
  ws ,
  "net.ruippeixotog" %% "scala-scraper" % "0.1.1",
  "org.apache.pdfbox" % "pdfbox" % "1.8.10")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  