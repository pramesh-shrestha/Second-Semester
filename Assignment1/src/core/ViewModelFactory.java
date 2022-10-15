package core;

import viewModel.HeaterPowerViewModel;
import viewModel.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private TemperatureViewModel temperatureViewModel;
  private HeaterPowerViewModel heaterPowerViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
    heaterPowerViewModel = new HeaterPowerViewModel(modelFactory.getTemperatureModel());
  }

  //getTemperatureViewModel()
  public TemperatureViewModel getTemperatureViewModel()
  {
    return temperatureViewModel;
  }

  //getHeaterPowerViewModel()
  public HeaterPowerViewModel getHeaterPowerViewModel()
  {
    return heaterPowerViewModel;
  }
}
