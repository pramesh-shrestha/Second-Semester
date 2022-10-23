package shared;

import java.io.Serializable;

public class Msg implements Serializable
{
  private String user;
  private String text;

  public Msg(String user, String text)
  {
    this.user = user;
    this.text = text;
  }

  public String getUser()
  {
    return user;
  }

  public String getText()
  {
    return text;
  }
}
