package Temperature.core;

import Temperature.model.TemperatureModel;
import Temperature.model.TemperatureModelManager;

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
