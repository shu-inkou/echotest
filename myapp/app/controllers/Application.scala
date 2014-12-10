package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.Play.current
import model.ChatRoom

object Application extends Controller {

  def index = Action {implicit request =>
    println("test");
    Ok(views.html.index("Your new application is ready."))
  }
  
  def socket = WebSocket.acceptWithActor[String, String] { request => out =>
    ChatRoom.addClient(out);
  }
}