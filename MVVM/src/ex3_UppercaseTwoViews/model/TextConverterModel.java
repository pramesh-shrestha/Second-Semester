package ex3_UppercaseTwoViews.model;

import java.util.ArrayList;
import java.util.List;

public class TextConverterModel implements TextConverter
{
  private ArrayList<String> list;

  public TextConverterModel()
  {
    list = new ArrayList<>();
  }

  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }

  @Override public void addLog(String log)
  {
    list.add("Converting: " + log);
  }

  public ArrayList<String> getLog()
  {
    return list;
  }


}
