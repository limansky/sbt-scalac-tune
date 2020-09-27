package me.limansky.sbtscalactune

import sbt._

trait SbtScalacTuneKeys {
  lazy val scalacOptionSet = settingKey[OptionSet]("Set of scalac options")
}

object SbtScalacTuneKeys extends SbtScalacTuneKeys
