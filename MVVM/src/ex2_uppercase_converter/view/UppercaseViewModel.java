package ex2_uppercase_converter.view;

import ex2_uppercase_converter.model.TextConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UppercaseViewModel
{
  //creating fields that resemble UpperCaseViewController's filed
  private StringProperty request;
  private StringProperty reply;
  private StringProperty errorLabel;
  private TextConverter textConverter;

  public UppercaseViewModel(TextConverter model)

  {
    textConverter = model;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    errorLabel = new SimpleStringProperty();
  }

  public void convert()
  {
    String str = request.get();
    if(str == null || str.equals(""))
    {
      errorLabel.set("Request box cannot be empty.");
    }
    else
    {
      String result = textConverter.toUppercase(str);
      reply.set(result);
      errorLabel.set(null);
    }

  }

//  public String getRequest()
//  {
//    return request.get();
//  }

  public StringProperty requestProperty()
  {
    return request;
  }

//  public String getReply()
//  {
//    return reply.get();
//  }

  public StringProperty replyProperty()
  {
    return reply;
  }

//  public String getErrorLabel()
//  {
//    return errorLabel.get();
//  }

  public StringProperty errorLabelProperty()
  {
    return errorLabel;
  }

}
