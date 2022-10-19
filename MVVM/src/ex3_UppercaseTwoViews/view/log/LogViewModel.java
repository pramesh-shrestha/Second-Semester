package ex3_UppercaseTwoViews.view.log;

import ex3_UppercaseTwoViews.model.TextConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class LogViewModel
{
  private TextConverter textConverter;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter model)
  {
    textConverter = model;
    logs = FXCollections.observableArrayList();
  }

  public ObservableList<String> getLogs()
  {
    return logs;
  }

  public void loadLogs()
  {
    String str = textConverter.getLog().toString();
    logs = FXCollections.observableArrayList(str);
  }
}
