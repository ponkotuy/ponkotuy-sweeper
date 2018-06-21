package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(assets: Assets) extends InjectedController {
  def index() = assets.at(path = "/public/html", file = "index.html")
}
