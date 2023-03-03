package uppercaseWS.model;

import java.util.ArrayList;

public class Converter {
  private ArrayList<String> history = new ArrayList<>();

  public String toUpperCase(String text){
    String result = text.toUpperCase();
    return result;
  }

  public String toLowerCase(String text){
    return text.toLowerCase();
  }

  public String[] getHistory() {
    String[] histories = history.toArray(new String[history.size()]);
    return histories;
  }
}
