package uppercaseWithLogs.core;

import uppercaseWithLogs.model.TextConverter;
import uppercaseWithLogs.model.TextConverterManager;

public class ModelFactory
{
  private TextConverter textConverterModel;
  public ModelFactory()
  {
    textConverterModel = new TextConverterManager();
  }

  public TextConverter getTextConverterModel()
  {
    return textConverterModel;
  }
}
