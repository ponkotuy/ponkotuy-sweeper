package controllers

import java.util.UUID

import javax.inject.{Inject, Singleton}
import models.Square
import msgpack4z._
import play.api.http.ContentTypes
import play.api.mvc.InjectedController

@Singleton
class SquareController @Inject()() extends InjectedController {
  import Square.instance
  import msgpack4z.CodecInstances.all._

  def list() = Action {
    val sqs = Square.findAll()
    Ok(MsgpackCodec[List[Square]].toBytes(sqs, MsgOutBuffer.create())).as("application/x-msgpack")
  }
}
