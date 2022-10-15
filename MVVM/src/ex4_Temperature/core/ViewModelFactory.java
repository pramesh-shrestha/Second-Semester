package ex4_Temperature.core;

import ex4_Temperature.viewModel.TemperatureViewModel;

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
