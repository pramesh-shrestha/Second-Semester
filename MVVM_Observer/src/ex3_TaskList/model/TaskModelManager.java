package ex3_TaskList.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> tasks;
  private PropertyChangeSupport support;

  //constructor
  public TaskModelManager()
  {
   tasks = new ArrayList<>();
   support = new PropertyChangeSupport(this);
  }

  //add task
  @Override public void addTask(String owner, String desc)
  {
    //using date from calcTimeStamp
    Task task = new Task(owner,desc,calcTimeStamp());
    tasks.add(task);
    //sending notification to the listener because we add a new task, something has changed. Using null for oldValue as it is not interesting here
    support.firePropertyChange("TaskAdded", null, task);
  }

  //get task
  @Override public Task getTask()
  {
    if(!tasks.isEmpty()){
      //removing first task of list
      Task removed = tasks.remove(0);
      //sending notification as something is removed
      support.firePropertyChange("TaskRemoved", null, removed);
      //returning the task that is removed
      return removed;
    }
    return null;
  }

  //calTimeStamp
  private String  calcTimeStamp()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    return sdf.format(now);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
