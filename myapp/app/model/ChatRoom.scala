package model

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorRefFactory
import akka.actor.Props
import java.io.Console
import play.libs.Akka

object ChatRoom{
  
  var clientList:List[ActorRef] = List()
  
  def addClient(out: ActorRef) = {
    clientList = out :: clientList
    Props(new ClientActor(out))
  }
}

class ClientActor(out: ActorRef) extends Actor {
  def receive = {
    case msg:String=> {
      ChatRoom.clientList.foreach { x => x ! ("your message=>" + msg) }
    }
  }
}