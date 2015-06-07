package controllers

import play.api._
import play.api.mvc._

/**
 * Created by yoda on 15/06/06.
 */
class TemplateController extends Controller{
  def show = Action {
    val list = List[String]("lemon","mikan","nanao")
    Ok(views.html.show("Hello Scala Templates!",list))
  }

}
