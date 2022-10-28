package shared;

import java.io.Serializable;

public class Message implements Serializable
{
  private String text;
  private String user;

  public Message(String user,String text)
  {
    this.text = text;
    this.user = user;
  }

  public String getText()
  {
    return text;
  }

  public String getUser()
  {
    return user;
  }
}
