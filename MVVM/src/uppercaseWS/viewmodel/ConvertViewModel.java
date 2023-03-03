package uppercaseWS.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import uppercaseWS.model.IModel;

public class ConvertViewModel {
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;
  private IModel model;

  public ConvertViewModel(IModel model) {
    this.model = model;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert(String str){
    if (str == null || str.equals("")) {
      error.set("Request field cannot be empty");
    }
    else {

      String result = model.convert(str);
      reply.setValue(result);
      error.set("");
    }
  }

  public void bindRequest(StringProperty property){
    property.bindBidirectional(request);
  }
  public void bindReply(StringProperty property){
    property.bind(reply);
  }
  public void bindError(StringProperty property){
    property.bind(error);
  }
}
