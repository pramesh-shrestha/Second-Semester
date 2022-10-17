package ex1_uppercase.Model;

import java.util.ArrayList;

public class Converter
{
  private ArrayList logList;

  //constructor
  public Converter()
  {
    logList = new ArrayList<>();
  }

  public String toUppercase(String text)
  {
    return text.toUpperCase();
  }

  public void addLog(String text)
  {
    logList.add(text);
  }

  public int getLogSize()
{
  return logList.size();
}

}
