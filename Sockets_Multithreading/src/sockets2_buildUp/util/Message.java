package sockets2_buildUp.util;

import java.io.Serializable;

public class Message implements Serializable
{
  private String messageBody;

  public Message(String messageBody)
  {
    this.messageBody = messageBody;
  }

  public String getMessageBody()
  {
    return messageBody;
  }

  @Override public String toString()
  {
    return "Message{" + "messageBody='" + messageBody + '\'' + '}';
  }
}
