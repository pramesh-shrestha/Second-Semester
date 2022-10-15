package ex3_TaskList.view.nextTask;

import ex3_TaskList.core.ViewHandler;
import ex3_TaskList.viewModel.NextTaskViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NextTaskViewController
{
  @FXML
  private Label creatorLabel;
  @FXML
  private Label dateLabel;
  @FXML
  private Label descLabel;
  @FXML
  private Label noTaskLabel;

  private NextTaskViewModel nextTaskViewModel;
  private ViewHandler viewHandler;

  public void init(NextTaskViewModel nextTaskViewModel, ViewHandler viewHandler)
  {
    this.nextTaskViewModel =nextTaskViewModel;
    this.viewHandler = viewHandler;
    creatorLabel.textProperty().bind(nextTaskViewModel.creatorProperty());
    dateLabel.textProperty().bind(nextTaskViewModel.dateProperty());
    descLabel.textProperty().bind(nextTaskViewModel.descriptionProperty());
    noTaskLabel.textProperty().bind(nextTaskViewModel.noTaskProperty());
  }

  public void onGetTaskButton()
  {
    nextTaskViewModel.getNextTask();
  }

  public void onBackButton()
  {
    viewHandler.openAllTaskView();
  }

}
