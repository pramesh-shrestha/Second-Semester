package Binding.core;

import Binding.model.ConverterModel;
import Binding.model.SimpleTextConverter;


public class ModelFactory
{
  private SimpleTextConverter simpleTextConverter;

  public ModelFactory()
  {
    simpleTextConverter = new ConverterModel();
  }

  public SimpleTextConverter getSimpleTextConverter()
  {
    return simpleTextConverter;
  }
}
