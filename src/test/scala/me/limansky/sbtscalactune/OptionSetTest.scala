package me.limansky.sbtscalactune

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OptionSetTest extends AnyFlatSpec with Matchers {
  "OptionSet" should "provide options for specified Scala version" in {
    val os = ScalacOptions.easy

    os.optionsFor("2.11.12") should contain theSameElementsAs List("-feature", "-deprecation", "-unchecked")
    os.optionsFor("2.13.3") should contain theSameElementsAs List("-feature", "-Xlint:deprecation", "-unchecked")
  }
}
