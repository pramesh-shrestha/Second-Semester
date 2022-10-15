package ex4_Thermometer.core;

import ex4_Thermometer.viewModel.TemperatureViewModel;

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
