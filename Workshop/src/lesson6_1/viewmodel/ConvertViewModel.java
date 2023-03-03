package lesson6_1.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lesson6_1.model.Model;

import java.beans.PropertyChangeEvent;

public class ConvertViewModel
{
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;
  private Model model;
  public ConvertViewModel(Model model)
  {
    this.model=model;
    request=new SimpleStringProperty();
    reply=new SimpleStringProperty();
    error=new SimpleStringProperty();

  }



  public void convert()
  {
   try {
     reply.set(model.convert(request.get()));
     error.set(null);
  }
    catch (Exception e)
  {
   error.set(e.getMessage());
  }
  }
  public void bindRequest(StringProperty property)
  {
    property.bindBidirectional(request);
  }
  public void bindReply(StringProperty property)
  {
   property.bindBidirectional(reply);
  }
  public void bindError(StringProperty property)
  {
    property.bindBidirectional(error);
  }
}
