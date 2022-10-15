package ex3_TaskList.viewModel;

import ex3_TaskList.model.TaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddTaskViewModel
{
  private TaskModel taskModel;
  private StringProperty creator;
  private StringProperty description;

  public AddTaskViewModel(TaskModel taskModel)
  {
    this.taskModel = taskModel;
    //String properties to hold the data shown in the GUI
    creator = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  public void addNewTask()
  {
    taskModel.addTask(creator.getValue(), description.getValue());
  }

  //Method to reset the data
  public void clear()
  {
    description.setValue("");
    creator.setValue("");
  }

  public TaskModel getTaskModel()
  {
    return taskModel;
  }

//get methods for the properties so that the controller can bind to them
  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }
}
