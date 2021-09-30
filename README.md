Broken ZIOApp on Scala.js
=========================

Two projects, one using `zio.App` from ZIO 1.0.11, the other
using `zio.ZIOApp` from ZIO 2.0.0-M3. Both programs are simply

```scala
putStrLn("hello zio")
```

and

```scala
printLine("hello zio")
```

Execute sequentially (witth `node` binary in path) with

```
sbt runBoth
```

Output:

```
> sbt runBoth
[info] welcome to sbt 1.5.5 (Amazon.com Inc. Java 1.8.0_302)
[info] loading settings for project zio2_zioapp_sjs-build from plugins.sbt ...
[info] loading project definition from /tmp/zio2_zioapp_sjs/project
[info] loading settings for project root from build.sbt ...
[info] set current project to zio2_zioapp_sjs (in build file:/tmp/zio2_zioapp_sjs/)
[info] compiling 1 Scala source to /tmp/zio2_zioapp_sjs/zio1/target/scala-2.13/classes ...
[info] Full optimizing /tmp/zio2_zioapp_sjs/zio1/target/scala-2.13/zio1-opt
[info] Closure: 0 error(s), 0 warning(s)
Executing /tmp/zio2_zioapp_sjs/zio1/target/scala-2.13/zio1-opt.js in project zio1
hello zio
[success] Total time: 17 s, completed Sep 30, 2021 9:34:02 AM
[info] compiling 1 Scala source to /tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/classes ...
[info] Full optimizing /tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt
[info] Closure: 0 error(s), 0 warning(s)
Executing /tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js in project zio2
/tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:330
Eu.prototype.iz=function(a){if(null===a)throw Ct(new Dt,"Defect: OneShot variable cannot be set to null value");if(null!==this.Ts)throw Ct(new Dt,"Defect: OneShot variable being set twice");this.Ts=a};Eu.prototype.da=function(){if(null===this.Ts)throw Ct(new Dt,"Cannot block for result to be set in JavaScript");return this.Ts};Eu.prototype.$classData=x({WT:0},!1,"zio.internal.OneShot",{WT:1,b:1});function by(a,b){return new Z(((c,d)=>()=>d)(a,b))}function cy(){}cy.prototype=new u;
                                                                                                                                                                                                                                                      ^

Dt [java.lang.Error]: Cannot block for result to be set in JavaScript
    at Eu.da (/tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:330:256)
    at Au (/tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:305:193)
    at zu (/tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:305:20)
    at /tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:1709:27
    at Object.<anonymous> (/tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:1709:421)
    at Object.<anonymous> (/tmp/zio2_zioapp_sjs/zio2/target/scala-2.13/zio2-opt.js:1710:4)
    at Module._compile (internal/modules/cjs/loader.js:999:30)
    at Object.Module._extensions..js (internal/modules/cjs/loader.js:1027:10)
    at Module.load (internal/modules/cjs/loader.js:863:32)
    at Function.Module._load (internal/modules/cjs/loader.js:708:14) {
  rG: 'Cannot block for result to be set in JavaScript',
  Mt: null,
  QV: true,
  sG: true,
  Zp: [Circular],
  Il: null
}
[success] Total time: 11 s, completed Sep 30, 2021 9:34:13 AM
```
