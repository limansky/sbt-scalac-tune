package me.limansky.sbtscalactune

object ScalacOptions {

  val deprecated: CompilerOption = CompilerOption(
    OptionVariant("-deprecation", until = Some(13)),
    OptionVariant("-Xlint:deprecation", since = Some(13))
  )

  val unchecked: CompilerOption = CompilerOption(OptionVariant("-unchecked"))
  val feature: CompilerOption = CompilerOption(OptionVariant("-feature"))

  val easy: OptionSet = OptionSet(
    Seq(
      deprecated,
      unchecked,
      feature
    ),
    fatalWarnings = false
  )

  val medium: OptionSet = easy.withOptions()

  val hard: OptionSet = medium.withOptions().fatal
}
