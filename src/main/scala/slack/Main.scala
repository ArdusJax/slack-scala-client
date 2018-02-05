package slack

import akka.actor._
import slack.api.SlackApiClient
import slack.models.Message
import slack.rtm.SlackRtmClient

object Main extends App {
  val token = "..."
  implicit val system = ActorSystem("slack")
  implicit val ec = system.dispatcher

  val client = SlackRtmClient(token)
  val slackApiClient = SlackApiClient(token)
  val selfId = client.state.self.id

  client.onEvent {
    case message: Message =>
      slackApiClient.postEphemeral(message.channel, "Only you can see this...")
      println("")
    case _ =>
      println("This is not the message that you're looking for...")
    //system.log.info("Received new event: {}", event)
    /*
    val mentionedIds = SlackUtil.extractMentionedIds(message.text)

    if (mentionedIds.contains(selfId)) {
      client.sendMessage(message.channel, s"<@${message.user}>: Hey!")
    }
    */
  }
}
