package controllers

import play.api.i18n.{Lang, Messages}
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.User

/**
 * Created by yoda on 15/06/06.
 */
class UserController extends Controller{
  implicit val messages: Messages = play.api.i18n.Messages.Implicits.applicationMessages(
    Lang("en"), play.api.Play.current)

  /** Form 定義 */
  val userForm = Form(
    mapping("name"->nonEmptyText,"email"->email)(User.apply)(User.unapply))

  /** 初期画面関数 */
  def entryInit = Action {
    val filedForm = userForm.fill(User("user name","email address"))
    Ok(views.html.user.entry(filedForm))
  }

  /** ユーザ登録関数  */
  def entrySubmit = Action {implicit request =>

     userForm.bindFromRequest.fold(
     errors => {
       println("error!")
       BadRequest(views.html.user.entry(errors))
     },
     success => {
       println("entry success!")
      Ok(views.html.user.entrySubmit())
     })
  }
}
