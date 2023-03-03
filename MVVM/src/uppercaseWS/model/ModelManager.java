package uppercaseWS.model;

public class ModelManager implements IModel{
  private Converter converter;

  public ModelManager(Converter converter) {
    this.converter = converter;
  }

  @Override
  public String convert(String course) {
    return converter.toUpperCase(course);
  }
}
