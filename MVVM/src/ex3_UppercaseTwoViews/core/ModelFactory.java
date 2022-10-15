package ex3_UppercaseTwoViews.core;

import ex3_UppercaseTwoViews.model.TextConverter;
import ex3_UppercaseTwoViews.model.TextConverterModel;

public class ModelFactory
{
  private TextConverter textConverter;

  public ModelFactory()
  {
    textConverter = new TextConverterModel();
  }

  public TextConverter getTextConverter()
  {
    return textConverter;
  }
}
