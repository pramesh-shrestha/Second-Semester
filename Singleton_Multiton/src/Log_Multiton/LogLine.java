package Log_Multiton;

import Log.DateTime;

public class LogLine
{
  private String text;
  private Log.DateTime dateTime;

  public LogLine(String text)
  {
    this.text = text;
    dateTime = new Log.DateTime();
  }

  public String getText()
  {
    return text;
  }

  public DateTime getDateTime()
  {
    return dateTime;
  }

  @Override public String toString()
  {
    return text + '\'' + ", dateTime=" + dateTime;
  }
}
