package ex3_TaskList.viewModel;

import ex3_TaskList.model.Task;
import ex3_TaskList.model.TaskModel;
import ex3_TaskList.model.TaskModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NextTaskViewModel
{
  private TaskModel taskModel;
  private StringProperty description;
  private StringProperty creator;
  private StringProperty date;
  private StringProperty noTask;

  public NextTaskViewModel(TaskModel taskModel)
  {
    this.taskModel = taskModel;
    description = new SimpleStringProperty();
    creator = new SimpleStringProperty();
    date = new SimpleStringProperty();
    noTask = new SimpleStringProperty();

  }

  public void getNextTask()
  {

    if(taskModel.getTask() == null || taskModel.getTask().equals(""))
    {
      clear();
      noTask.setValue("No more tasks left.");
    }
    else
    {
      Task task = taskModel.getTask();
      description.setValue(task.getDescription());
      creator.setValue(task.getOwner());
      date.setValue(task.getTimeCreated());
    }



  }

  public void clear()
  {
    description.setValue("");
    creator.setValue("");
    date.setValue("");
  }

  public TaskModel getTaskModel()
  {
    return taskModel;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty dateProperty()
  {
    return date;
  }

  public StringProperty noTaskProperty()
  {
    return noTask;
  }
}
