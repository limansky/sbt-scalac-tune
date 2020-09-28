package me.limansky.sbtscalactune

import sbt.CrossVersion

final class CompilerOption(val variants: Seq[OptionVariant])

object CompilerOption {
  def apply(v: OptionVariant, vs: OptionVariant*): CompilerOption = new CompilerOption(v +: vs)
}

final case class OptionVariant(variant: String, since: Option[Int] = None, until: Option[Int] = None)

final case class OptionSet(options: Seq[CompilerOption], fatalWarnings: Boolean) {
  def withOptions(opts: CompilerOption*): OptionSet = copy(options = this.options ++ opts)
  def fatal: OptionSet = copy(fatalWarnings = true)
  def nonFatal: OptionSet = copy(fatalWarnings = false)

  def optionsFor(scalaVersion: String): Seq[String] = {
    CrossVersion.partialVersion(scalaVersion) match {
      case Some((_, minor)) =>
        val opts = options
          .flatMap(op => op.variants.find(v => v.since.forall(_ <= minor) && v.until.forall(minor < _)))
          .map(_.variant)

        if (fatalWarnings) "-Xfatal-warnings" +: opts else opts
      case _ => Seq.empty
    }
  }
}
