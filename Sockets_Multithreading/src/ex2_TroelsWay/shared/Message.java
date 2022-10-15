package ex2_TroelsWay.shared;

import java.io.Serializable;

public class Message implements Serializable
{
  private String message;
  private int id;

  public Message(String message, int id)
  {
    this.message = message;
    this.id = id;
  }

  public String getMessage()
  {
    return message;
  }

  public int getId()
  {
    return id;
  }
}
