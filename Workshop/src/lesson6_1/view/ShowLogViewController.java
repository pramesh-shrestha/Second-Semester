package lesson6_1.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import lesson6_1.viewmodel.ConvertViewModel;
import lesson6_1.viewmodel.ShowLogViewModel;

public class ShowLogViewController
{
  @FXML
  private ListView<String> logList = new ListView<>();
  private ViewHandler viewHandler;
  private ShowLogViewModel viewModel;
  private Region root;
  public void init(ViewHandler viewHandler, ShowLogViewModel viewModel, Region root)
  {
    this.viewHandler=viewHandler;
    this.viewModel=viewModel;
    this.root=root;
    viewModel.bindLogs(logList.itemsProperty());
  }
  public void reset()
  {}
  public Region getRoot()
  {
    return root;
  }

  @FXML
  public void onBack()
  {
    viewHandler.openView("convert");
  }
}
