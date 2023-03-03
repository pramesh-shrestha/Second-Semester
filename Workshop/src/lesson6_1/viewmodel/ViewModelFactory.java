package lesson6_1.viewmodel;

import lesson6_1.model.Model;

public class ViewModelFactory
{
  private ConvertViewModel convertViewModel;
  private ShowLogViewModel showLogViewModel;
  public ViewModelFactory(Model model)
  {
    convertViewModel = new ConvertViewModel(model);
    showLogViewModel = new ShowLogViewModel(model);
  }
  public ConvertViewModel getConvertViewModel()
  {
    return convertViewModel;
  }

  public ShowLogViewModel getShowLogViewModel()
  {
    return showLogViewModel;
  }
}
