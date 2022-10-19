package uppercaseWithLogs.view.log;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uppercaseWithLogs.core.ViewHandler;
import uppercaseWithLogs.core.ViewModelFactory;
import uppercaseWithLogs.model.LogEntry;
import uppercaseWithLogs.view.ViewController;
import uppercaseWithLogs.viewModel.LogViewModel;

public class LogViewController implements ViewController
{
  @FXML
  private TableView<LogEntry> tableView;
  @FXML
  private TableColumn<LogEntry, String> inputColumn;
  @FXML
  private TableColumn<LogEntry, String>  outputColumn;

  private ViewHandler viewHandler;
  private LogViewModel logViewModel;



  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;
    logViewModel =  vmf.getLogViewModel();
    logViewModel.loadLogs(); //first we need to load logs before we set it to the table
    tableView.setItems(logViewModel.getLog());
    inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
    outputColumn.setCellValueFactory(new PropertyValueFactory<>("output"));

  }

  public void onBackButton()
  {
    viewHandler.openToUpperCase();
  }
}
