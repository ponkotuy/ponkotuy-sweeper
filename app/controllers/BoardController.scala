package controllers

import java.util.UUID

import javax.inject.Inject
import models.Square
import msgpack4z.{MsgInBuffer, MsgpackCodec}
import play.api.mvc.InjectedController
import requests.CreateBoard
import scalikejdbc.DB

import scala.util.Random

class BoardController @Inject()() extends InjectedController {
  import Responses._
  def create() = Action(parse.byteString) { req =>
    MsgpackCodec[CreateBoard].unpackAndClose(MsgInBuffer(req.body.toArray)).fold(msgpackError, { board =>
      val boardId = UUID.randomUUID()
      val random = new Random()
      val squares = for {
        x <- 0 until board.x
        y <- 0 until board.y
      } yield Square(UUID.randomUUID(), boardId, x, y, random.nextBoolean(), opened = false)
      DB localTx(Square.batchCreate(squares)(_))
      Success
    })
  }
}
