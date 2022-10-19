package uppercaseWithLogs.viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uppercaseWithLogs.model.LogEntry;
import uppercaseWithLogs.model.TextConverter;

import java.util.List;

public class LogViewModel
{
  private ObservableList<LogEntry> logs;
  private TextConverter textConverterModel;

  public LogViewModel(TextConverter textConverterModel)
  {
    this.textConverterModel = textConverterModel;
  }

  public void loadLogs()
  {
    List<LogEntry> logList = textConverterModel.getLogs();
    logs = FXCollections.observableArrayList(logList);
  }

  public ObservableList<LogEntry> getLog()
  {
    return logs;
  }

}
