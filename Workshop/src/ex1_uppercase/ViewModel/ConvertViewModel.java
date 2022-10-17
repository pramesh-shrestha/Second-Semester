package ex1_uppercase.ViewModel;

import ex1_uppercase.Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConvertViewModel
{
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;
  private Model model;

  //constructor
  public ConvertViewModel(Model model)
  {
    this.model = model;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert()
  {
    String str = model.convert(request.get());
    reply.set(str);

    if(request.get() ==  null || request.get().equals(""))
      error.set("Request field cannot be empty.");
  }

  public String getRequest()
  {
    return request.get();
  }

  public StringProperty requestProperty()
  {
    return request;
  }

  public String getReply()
  {
    return reply.get();
  }

  public StringProperty replyProperty()
  {
    return reply;
  }

  public String getError()
  {
    return error.get();
  }

  public StringProperty errorProperty()
  {
    return error;
  }
}
