import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport.fullOptJS
import sbt._
import sbt.Keys._
import scala.sys.process._

object Run {

  def compileAndRun = Def.task {
    val proj    = name.value
    val optFile = (Compile / fullOptJS).value.data
    println(s"Executing $optFile in project $proj")
    List("node", optFile.getAbsolutePath).!
    ()
  }

}
