package ex3_TaskList.core;

import ex3_TaskList.view.addTask.AddTaskViewController;
import ex3_TaskList.view.allTasks.AllTaskViewController;
import ex3_TaskList.view.nextTask.NextTaskViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;
  private Scene addTaskViewScene;
  private Scene nextTaskViewScene;
  private Scene allTaskViewScene;
  private Stage stage;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;

  }
  //start method
  public void start()
  {
    stage = new Stage();
    openAllTaskView();

  }

  public void openAllTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/allTasks/AllTaskView.fxml"));
    try
    {
      Parent root = loader.load();
      AllTaskViewController controller = loader.getController();
      controller.init(viewModelFactory.getAllTaskViewModel(),this);
      stage.setTitle("All Tasks");
      allTaskViewScene = new Scene(root);
      stage.setScene(allTaskViewScene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void openAddTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/addTask/AddTaskView.fxml"));
    try
    {
      Parent root = loader.load();
      AddTaskViewController controller = loader.getController();
      controller.init(viewModelFactory.getAddTaskViewModel(),this);
      stage.setTitle("Add Tasks");
      addTaskViewScene = new Scene(root);
      stage.setScene(addTaskViewScene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public void openNextTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/nextTask/NextTaskView.fxml"));
    try
    {
      Parent root = loader.load();
      NextTaskViewController controller = loader.getController();
      controller.init(viewModelFactory.getNextTaskViewModel(),this);
      stage.setTitle("Next Tasks");
      nextTaskViewScene = new Scene(root);
      stage.setScene(nextTaskViewScene);
      stage.show();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
