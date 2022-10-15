package ex3_TaskList.view.addTask;

import ex3_TaskList.core.ViewHandler;
import ex3_TaskList.viewModel.AddTaskViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddTaskViewController
{
  @FXML
  private TextField creatorField;
  @FXML
  private TextField descriptionField;
  private AddTaskViewModel addTaskViewModel;
  private ViewHandler viewHandler;
  public void init(AddTaskViewModel addTaskViewModel, ViewHandler viewHandler)
  {
    this.addTaskViewModel = addTaskViewModel;
    this.viewHandler = viewHandler;
    creatorField.textProperty().bindBidirectional(addTaskViewModel.creatorProperty());
    descriptionField.textProperty().bindBidirectional(addTaskViewModel.descriptionProperty());
  }
  public void onAddButton()
  {
    addTaskViewModel.addNewTask();
    addTaskViewModel.clear();
  }

  public void onBackButton()
  {
    viewHandler.openAllTaskView();
  }
}
