package requests

import msgpack4z.MsgpackCodec
import msgpack4z.CodecInstances.all._
import utils.MyMsgPack

case class CreateBoard(x: Int, y: Int, bomb: Int)

object CreateBoard {
  implicit val instance: MsgpackCodec[CreateBoard] =
    MyMsgPack.mapCodecStringKey.codec(CreateBoard.apply _, CreateBoard.unapply _)("x", "y", "bomb")
}
