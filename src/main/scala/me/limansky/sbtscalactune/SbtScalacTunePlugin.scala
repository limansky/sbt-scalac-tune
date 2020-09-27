package me.limansky.sbtscalactune

import me.limansky.sbtscalactune.SbtScalacTuneKeys._
import sbt.Keys._
import sbt.{ AutoPlugin, Def, PluginTrigger }

object SbtScalacTunePlugin extends AutoPlugin {
  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = {
    Seq(
      scalacOptionSet := ScalacOptions.medium,
      scalacOptions ++= scalacOptionSet.value.optionsFor(scalaVersion.value)
    )
  }
}
