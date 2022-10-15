package ex2_multipleClientsID.util;

import java.io.Serializable;

public class Message implements Serializable
{
  private String message;
  private int id;

  public Message(String message, int id)
  {
    this.message = message;

  }

  public Message(String message) {
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }

  public int getId()
  {
    return id;
  }

  @Override
  public String toString()
  {
    return  message;
  }
}
