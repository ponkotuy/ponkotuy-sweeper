package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.InjectedController

@Singleton
class MyAssets @Inject()(assets: Assets) extends InjectedController {
  def html(file: String) =
    assets.at(path = "/public/html", file = file)

  def javascripts(file: String) =
    assets.at(path = "/public/javascripts", file = file)
}
