package ex4_Thermometer.mediator;

import ex4_Thermometer.model.Temperature;
import ex4_Thermometer.model.TemperatureList;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);

  TemperatureList getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
}
