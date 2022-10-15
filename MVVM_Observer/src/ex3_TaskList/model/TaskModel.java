package ex3_TaskList.model;

import ex3_TaskList.util.PropertyChangeSubject;

public interface TaskModel extends PropertyChangeSubject
{
  void addTask(String owner, String  desc);
  Task getTask();
}
