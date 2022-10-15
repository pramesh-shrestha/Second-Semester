package ex4_Thermometer.mediator;

import ex4_Thermometer.model.Temperature;
import ex4_Thermometer.model.TemperatureList;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
  }

  @Override public void addTemperature(String id, double temperatureValue)
  {
    Temperature old = getLastInsertedTemperature(id);
     if (old == null)
    {
      temperatureList.addTemperature(new Temperature(id,temperatureValue));
    }
    System.out.println(temperatureList);
  }

  @Override
  public TemperatureList getLastInsertedTemperature()
  {
    return temperatureList;
  }

  @Override
  public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }
}
