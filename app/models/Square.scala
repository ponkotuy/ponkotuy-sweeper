package models

import java.util.UUID

import msgpack4z.MsgpackCodec
import msgpack4z.CodecInstances.all._
import scalikejdbc._
import skinny.orm.{Alias, SkinnyCRUDMapperWithId}
import utils.MyMsgPack
import TypeBinders._

case class Square(
    id: UUID,
    boardId: UUID,
    x: Int,
    y: Int,
    bomb: Boolean,
    opened: Boolean,
)

object Square extends SkinnyCRUDMapperWithId[UUID, Square] {
  import MyMsgPack.UUIDCodec
  override def idToRawValue(id: UUID): Any = id
  override def rawValueToId(value: Any): UUID = UUID.fromString(value.toString)
  override val defaultAlias: Alias[Square] = createAlias("s")
  override def extract(rs: WrappedResultSet, n: ResultName[Square]): Square = autoConstruct(rs, n)

  implicit val instance: MsgpackCodec[Square] =
    MyMsgPack.mapCodecStringKey.codec(Square.apply _, Square.unapply _)("id", "boardId", "x", "y", "bomb", "opened")
}
