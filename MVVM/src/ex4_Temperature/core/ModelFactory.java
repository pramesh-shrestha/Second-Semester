package ex4_Temperature.core;

import ex4_Temperature.model.TemperatureModel;
import ex4_Temperature.model.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public ModelFactory()
  {
    this.temperatureModel = new TemperatureModelManager();
  }

  public TemperatureModel getTemperatureModel()
  {
    return temperatureModel;
  }
}
