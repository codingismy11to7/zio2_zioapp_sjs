package test

import zio.Console.printLine
import zio._

object Main extends ZIOAppDefault {
  override val run: ZIO[ZEnv with Has[ZIOAppArgs], Any, Any] = printLine("hello zio")
}
