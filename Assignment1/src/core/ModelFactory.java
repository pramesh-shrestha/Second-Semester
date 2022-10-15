package core;

import model.TemperatureModel;
import model.TemperatureModelManager;

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
