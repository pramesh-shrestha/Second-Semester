package Binding.viewmodel;

import Binding.model.SimpleTextConverter;
import javafx.beans.property.SimpleStringProperty;

public class ConverterViewModel
{
  private SimpleStringProperty text1;
  private SimpleStringProperty text2;
  private SimpleTextConverter simpleTextConverter;

  public ConverterViewModel(SimpleTextConverter simpleTextConverter)
  {
    this.simpleTextConverter = simpleTextConverter;
    text1 = new SimpleStringProperty();
    text2 = new SimpleStringProperty();
  }

  public void convert()
  {
    String str = text1.get();
    String result = simpleTextConverter.toUppercase(str);
    text2.set(result);
  }

  public SimpleStringProperty Text1Property()
  {
    return text1;
  }
  public SimpleStringProperty Text2Property()
  {
    return text2;
  }
}
