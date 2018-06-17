package controllers

import msgpack4z.UnpackError
import play.api.mvc.{Result, Results}

object Responses {
  val Success = Results.Ok("Success")
  def msgpackError(err: UnpackError): Result =
    Results.BadRequest(s"Failed unpack msgpack.\nmessage = ${err.getMessage}\ntrace = ${err.getStackTrace.mkString("\n")}")
}
