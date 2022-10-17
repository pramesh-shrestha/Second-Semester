package ex1_uppercase.Model;

import ex1_uppercase.Model.Model;

public class ModelManager implements Model
{
  private Converter converter;

  //constructor
  public ModelManager()
  {
   converter = new Converter();
  }

  @Override public String convert(String source)
  {
    return converter.toUppercase(source);
  }

  @Override public void addLog(String log)
  {
    converter.addLog(log);
  }
}
