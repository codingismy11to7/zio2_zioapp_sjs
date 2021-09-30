package test

import zio._
import zio.console.putStrLn

object Main extends App {
  final val program = putStrLn("hello zio")

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = program.exitCode
}
