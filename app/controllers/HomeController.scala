package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()() extends InjectedController {
  import Responses._
  def index() = Action {
    Success
  }
}
