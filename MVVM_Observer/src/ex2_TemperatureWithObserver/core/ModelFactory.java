package ex2_TemperatureWithObserver.core;

import ex2_TemperatureWithObserver.model.TemperatureModel;
import ex2_TemperatureWithObserver.model.TemperatureModelManager;

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
