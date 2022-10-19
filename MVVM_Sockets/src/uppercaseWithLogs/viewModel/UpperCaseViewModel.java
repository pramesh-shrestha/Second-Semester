package uppercaseWithLogs.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import uppercaseWithLogs.model.TextConverter;

public class UpperCaseViewModel
{
  private StringProperty request;
  private StringProperty reply;
  private StringProperty errorLabel;
  private TextConverter textConverterModel;

  public UpperCaseViewModel(TextConverter textConverterModel)
  {
    this.textConverterModel = textConverterModel;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    errorLabel = new SimpleStringProperty();
  }

  public void convert()
  {
    String input = request.get();
    if(input != null && !input.equals(""))
    {
      String result = textConverterModel.toUpperCase(input);
      reply.set(result);
    }
    else
      errorLabel.set("Input cannot be empty");
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

}
