name := "zio2_zioapp_sjs"

(ThisBuild / version) := "0.1.0"

(ThisBuild / scalaVersion) := "2.13.6"

(ThisBuild / scalacOptions) ++= Seq("-deprecation", "-Xfatal-warnings")

val compileAndRun = taskKey[Unit]("Compile javascript and execute with Node")

lazy val zio1 = project
  .in(file("zio1"))
  .settings(
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "dev.zio"           %%% "zio"             % "1.0.11",
      "io.github.cquiroz" %%% "scala-java-time" % "2.3.0",
    ),
    compileAndRun := Run.compileAndRun.value,
  )
  .enablePlugins(ScalaJSPlugin)

lazy val zio2 = project
  .in(file("zio2"))
  .settings(
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "dev.zio"           %%% "zio"             % "2.0.0-M3",
      "io.github.cquiroz" %%% "scala-java-time" % "2.3.0",
    ),
    compileAndRun := Run.compileAndRun.value,
  )
  .enablePlugins(ScalaJSPlugin)

lazy val root = project
  .in(file("."))
  .aggregate(zio1, zio2)
  .settings(
    publish := {},
    publishLocal := {},
  )

addCommandAlias("runBoth", ";zio1/compileAndRun;zio2/compileAndRun")
