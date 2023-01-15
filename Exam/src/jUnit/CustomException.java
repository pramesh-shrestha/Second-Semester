package jUnit;

/**
 * CustomException is a class that extends the Exception class and has a
 * constructor that takes a String as a parameter.
 */
public class CustomException extends Exception
{
  public CustomException(String message)
  {
    super(message);
  }

}
