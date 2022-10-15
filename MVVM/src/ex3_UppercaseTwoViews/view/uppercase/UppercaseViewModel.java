package ex3_UppercaseTwoViews.view.uppercase;

import ex3_UppercaseTwoViews.model.TextConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

import java.util.ArrayList;

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
  public void openView(String log)
  {
    textConverter.addLog(log);

  }
  public StringProperty requestProperty()
  {
    return request;
  }

  public StringProperty replyProperty()
  {
    return reply;
  }

  public StringProperty errorLabelProperty()
  {
    return errorLabel;
  }

  public void clear()
  {
    request.set("");
    reply.set("");
    errorLabel.set("");
  }



}
