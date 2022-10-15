package ex3_TaskList.viewModel;

import ex3_TaskList.model.Task;
import ex3_TaskList.model.TaskModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;

public class AllTaskViewModel
{
  private ObservableList<Task> tasks;

  public AllTaskViewModel(TaskModel taskModel)
  {
    tasks = FXCollections.observableArrayList();
    //Add listeners
    taskModel.addPropertyChangeListener("TaskAdded", evt -> taskAdded(evt));
    taskModel.addPropertyChangeListener("TaskRemoved", evt -> taskRemoved(evt));

  }
  private void taskAdded(PropertyChangeEvent evt)
  {
    //because getNewValue returns Object, we must explicitly tell java that it is Task object
    tasks.add((Task) evt.getNewValue());
  }
  private void taskRemoved(PropertyChangeEvent evt)
  {
    tasks.remove((Task) evt.getNewValue());
  }

  public ObservableList<Task> getTasksList()
  {
    return tasks;
  }


}
