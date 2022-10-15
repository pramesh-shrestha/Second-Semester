package ex4_Thermometer.core;

import ex4_Thermometer.mediator.TemperatureModel;
import ex4_Thermometer.mediator.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public ModelFactory()
  {
    temperatureModel = new TemperatureModelManager();
  }

  public TemperatureModel getTemperatureModel()
  {
    return temperatureModel;
  }
}
