package chatExample.shared;

import java.io.Serializable;

public class Message implements Serializable //because it is sent across network, there it must be serialized to be able to convert to bytes
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
}
