package ex3_TaskList;

import ex3_TaskList.core.ModelFactory;
import ex3_TaskList.core.ViewHandler;
import ex3_TaskList.core.ViewModelFactory;
import ex3_TaskList.model.Task;
import ex3_TaskList.model.TaskModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskListApp extends Application
{

  @Override
  public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();

  }
}
