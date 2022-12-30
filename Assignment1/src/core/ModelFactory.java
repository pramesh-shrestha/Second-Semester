package core;

import model.mediator.TemperatureModel;
import model.mediator.TemperatureModelManager;

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
