package observable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


import java.util.TimerTask;

public class AlphabetAnimation extends TimerTask {
  private StringProperty text = new SimpleStringProperty("A");

  public StringProperty textProperty() {
    return text;
  }

  public String getText() {
    return text.get();
  }

  @Override
  public void run() {
    int ch = text.get().charAt(0); //returns the character value of index 0
    ch++;
    text.set(String.valueOf((char)ch)); //sets the text
  }
}
