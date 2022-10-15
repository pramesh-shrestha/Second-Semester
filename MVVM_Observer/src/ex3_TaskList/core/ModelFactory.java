package ex3_TaskList.core;

import ex3_TaskList.model.TaskModel;
import ex3_TaskList.model.TaskModelManager;

public class ModelFactory
{
  private TaskModel taskModel;

  public ModelFactory()
  {
    taskModel = new TaskModelManager();
  }

  public TaskModel getTaskModel()
  {
    return taskModel;
  }
}
