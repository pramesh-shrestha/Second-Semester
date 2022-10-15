package ex2_TemperatureWithObserver.core;

import ex2_TemperatureWithObserver.viewModel.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    return temperatureViewModel;
  }
}
