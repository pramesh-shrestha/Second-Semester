package ex1_uppercase.ViewModel;

import ex1_uppercase.Model.Model;

public class ViewModelFactory
{
  private ConvertViewModel viewModel;

  public ViewModelFactory(Model model)
  {
    this.viewModel = new ConvertViewModel(model);
  }

  public ConvertViewModel getViewModel()
  {
    return viewModel;
  }
}
