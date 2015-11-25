package scodec
package msgpack

import org.scalacheck.Prop._
import org.scalacheck.Arbitrary._
import org.scalatest.prop.Checkers

class MessagePackSpec extends TestSuite with Checkers {

  "bool" should "be able to encode and decode" in {
    check(forAll((b: Boolean) => roundtrip(msgpack.bool, b)))
  }

  "int" should "be able to encode and decode" in {
    check(forAll((a: Int) => roundtrip(msgpack.int, a)))
  }

  "long" should "be able to encode and decode" in {
    check(forAll((l: Long) => roundtrip(msgpack.long, l)))
  }

  "float" should "be able to encode and decode" in {
    check(forAll((f: Float) => roundtrip(msgpack.float, f)))
  }

  "double" should "be able to encode and decode" in {
    check(forAll((d: Double) => roundtrip(msgpack.double, d)))
  }

  "string" should "be able to encode and decode" in {
    check(forAll((s: String) => roundtrip(msgpack.str, s)))
  }

  implicit val intSerializer = Serialize.int

  "array" should "be able to encode and decode" in {
    check(forAll((a: Vector[Int]) => roundtrip(msgpack.array, a)))
  }

  "map" should "be able to encode and decode" in {
    check(forAll((m: Map[Int, Int]) => roundtrip(msgpack.map, m)))
  }

  case class Point(x: Int, y: Int, z: Int)
  val pointCodec = (msgpack.int :: msgpack.int :: msgpack.int).as[Point]

  "Point" should "be able to encode and decode" in {
    roundtrip(pointCodec, Point(1000, 5, 2))
  }
}
