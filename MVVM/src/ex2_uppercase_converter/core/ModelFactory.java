package ex2_uppercase_converter.core;

import ex2_uppercase_converter.model.TextConverter;
import ex2_uppercase_converter.model.TextConverterModel;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter()
  {
    if(textConverter == null)
      textConverter = new TextConverterModel();
    return textConverter;
  }
}
