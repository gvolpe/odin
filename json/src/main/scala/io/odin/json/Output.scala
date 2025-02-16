package io.odin.json

import scala.collection.compat._

import cats.syntax.show._
import com.github.plokhotnyuk.jsoniter_scala.core._
import io.odin.Level

final private[json] case class Output(
    level: Level,
    message: String,
    context: Map[String, String],
    exception: Option[String],
    position: String,
    threadName: String,
    timestamp: String
)

object Output {
  implicit private[json] val levelCodec: JsonValueCodec[Level] = new JsonValueCodec[Level] {

    // we never decode these
    override def decodeValue(in: JsonReader, default: Level): Level = ???

    override def encodeValue(x: Level, out: JsonWriter): Unit = out.writeVal(x.show)

    override def nullValue: Level = null

  }

  // generated by the jsoniter macros in scala 2.13 and copy pasted here for scala 3 compat
  // modified slightly so it compiles in scala 2.12, 2.13 and 3
  // once jsoniter-scala gets scala 3 support we can just use JsonCodecMaker instead
  implicit private[json] val codec: JsonValueCodec[Output] = {
    val x = {
      final class $anon extends _root_.com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec[Output] {
        def nullValue: Output = null;

        def decodeValue(
            in: _root_.com.github.plokhotnyuk.jsoniter_scala.core.JsonReader,
            default: Output
        ): Output = ???
        def encodeValue(
            x: Output,
            out: _root_.com.github.plokhotnyuk.jsoniter_scala.core.JsonWriter
        ): _root_.scala.Unit = e0(x, out);

        private[this] def e1(
            x: scala.collection.immutable.Map[String, String],
            out: _root_.com.github.plokhotnyuk.jsoniter_scala.core.JsonWriter
        ): _root_.scala.Unit = {
          out.writeObjectStart();
          x.foreachEntry(
            (
                (
                    k,
                    v
                ) => {
                  out.writeKey(k);
                  out.writeVal(v)
                }
            )
          );
          out.writeObjectEnd()
        };
        private[this] def e0(
            x: Output,
            out: _root_.com.github.plokhotnyuk.jsoniter_scala.core.JsonWriter
        ): _root_.scala.Unit = {
          out.writeObjectStart();
          {
            out.writeNonEscapedAsciiKey("level");
            Output.this.levelCodec.encodeValue(x.level, out)
          };
          {
            out.writeNonEscapedAsciiKey("message");
            out.writeVal(x.message)
          };
          {
            val v = x.context;
            if (v.isEmpty.`unary_!`) {
              out.writeNonEscapedAsciiKey("context");
              e1(v, out)
            } else
              ()
          };
          {
            val v = x.exception;
            if (v.ne(_root_.scala.None)) {
              out.writeNonEscapedAsciiKey("exception");
              out.writeVal(v.get)
            } else
              ()
          };
          {
            out.writeNonEscapedAsciiKey("position");
            out.writeVal(x.position)
          };
          {
            out.writeNonEscapedAsciiKey("thread_name");
            out.writeVal(x.threadName)
          };
          {
            out.writeNonEscapedAsciiKey("timestamp");
            out.writeVal(x.timestamp)
          };
          out.writeObjectEnd()
        };
      };
      new $anon()
    };
    x
  }
}
