name := """ponkotuy-sweeper"""
organization := "com.ponkotuy"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  guice,
  "org.postgresql" % "postgresql" % "42.2.2",
  "com.github.xuwei-k" %% "msgpack4z-circe" % "0.6.0",
  "com.github.xuwei-k" %% "msgpack4z-native" % "0.3.5", // もしくは https://github.com/msgpack4z/msgpack4z-java 使うことも可能
  "org.skinny-framework" %% "skinny-orm" % "2.6.0",
  "org.flywaydb" %% "flyway-play" % "5.0.0",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.6.0-scalikejdbc-3.2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)
