package Binding.model;

public class ConverterModel implements SimpleTextConverter
{
  @Override public String toUppercase(String str)
  {
    return str.toUpperCase();
  }
}
