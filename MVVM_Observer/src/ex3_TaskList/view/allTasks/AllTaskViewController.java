package ex3_TaskList.view.allTasks;

import ex3_TaskList.model.Task;
import ex3_TaskList.core.ViewHandler;
import ex3_TaskList.viewModel.AllTaskViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AllTaskViewController
{
  @FXML
  private TableColumn<Task, String> creatorCol;
  @FXML
  private TableColumn<Task, String> dateCol;
  @FXML
  private TableColumn<Task, String> descriptionCol;
  @FXML
  private TableView<Task> tableView; //because TableView contains Task
  private AllTaskViewModel allTaskViewModel;
  private ViewHandler viewHandler;

  public void init(AllTaskViewModel allTaskViewModel, ViewHandler viewHandler)
  {
    this.allTaskViewModel = allTaskViewModel;
    this.viewHandler = viewHandler;
    creatorCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
    dateCol.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
    tableView.setItems(allTaskViewModel.getTasksList());
  }
  public void onAddTable()
  {
    viewHandler.openAddTaskView();
  }

  public void onNextTable()
  {
    viewHandler.openNextTaskView();
  }

}


