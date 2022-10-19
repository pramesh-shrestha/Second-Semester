package ex3_UppercaseTwoViews.view.log;

import ex3_UppercaseTwoViews.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class LogViewController
{
  @FXML
  private ListView<String> logList;
  private ViewHandler viewHandler;
  private LogViewModel logViewModel;

  public void init(LogViewModel logViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    logViewModel.loadLogs();
    logList.setItems(logViewModel.getLogs());
  }

  public void onBack(ActionEvent actionEvent)
  {
    viewHandler.openToUppercase();
  }
}


