package utils

import java.util.UUID

import msgpack4z._
import scalaz.\/

object MyMsgPack {
  val mapCodecStringKey: CaseMapCodec[String] = CaseMapCodec.string(MyFactory)

  implicit object UUIDCodec extends MsgpackCodec[UUID] {
    override def pack(packer: MsgPacker, a: UUID): Unit = packer.packString(a.toString)

    override def unpack(unpacker: MsgUnpacker): UnpackResult[UUID] =
      \/.fromTryCatchNonFatal(UUID.fromString(unpacker.unpackString()))
          .leftMap(Err)
  }
}

object MyFactory extends PackerUnpackerFactory {
  override def packer: MsgPacker = MsgOutBuffer.create()
  override def unpacker(bytes: Array[Byte]): MsgUnpacker = MsgInBuffer(bytes)
}
