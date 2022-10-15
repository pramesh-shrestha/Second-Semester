package ex3_TaskList.core;

import ex3_TaskList.viewModel.AddTaskViewModel;
import ex3_TaskList.viewModel.AllTaskViewModel;
import ex3_TaskList.viewModel.NextTaskViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private AllTaskViewModel allTaskViewModel;
  private AddTaskViewModel addTaskViewModel;
  private NextTaskViewModel nextTaskViewModel;



  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    allTaskViewModel = new AllTaskViewModel(modelFactory.getTaskModel());
    addTaskViewModel = new AddTaskViewModel(modelFactory.getTaskModel());
    nextTaskViewModel = new NextTaskViewModel(modelFactory.getTaskModel());
  }

  public AllTaskViewModel getAllTaskViewModel()
  {
    return allTaskViewModel;
  }

  public AddTaskViewModel getAddTaskViewModel()
  {
    return addTaskViewModel;
  }

  public NextTaskViewModel getNextTaskViewModel()
  {
    return nextTaskViewModel;
  }
}
