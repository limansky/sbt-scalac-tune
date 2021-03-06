lazy val sbtScalacTune = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-scalac-tune",
    crossSbtVersions := List("0.13.18", "1.2.8"),
    scalacOptions := Seq("-deprecation", "-unchecked", "-Xlint", "-feature"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.2" % Test
    ),
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false,
    buildSettings
  )

lazy val buildSettings = Seq(
  organization := "me.limansky",
  description := "An sbt plugin to easy set scalac options",
  licenses := Seq(("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))),
  developers := List(
    Developer("limansky", "Mike Limansky", "mike.limansky at gmail.com", url("http://www.limansky.me/"))
  ),
  startYear := Some(2020),
  scmInfo := Some(
    ScmInfo(url("https://github.com/limansky/sbt-scalac-tune"), "scm:git:git@github.com:limansky/sbt-scalac-tune.git")
  ),
  homepage := scmInfo.value map (_.browseUrl),
  publishTo := sonatypePublishToBundle.value
)
