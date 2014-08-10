import SCodecMsgPackBuild._

name := "scodec-msgpack"

version in ThisBuild := "0.1.0-SNAPSHOT"

licenses in ThisBuild := Seq("MIT License" -> url("http://www.opensource.org/licenses/mit-license.php"))

scalacOptions in ThisBuild ++= Seq(
  "-deprecation",
  "-feature"
)

