package model.mediator;

import util.PropertyChangeSubject;
import model.radiator.Radiator;

import model.temperature.Temperature;

public interface TemperatureModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temperature);
  Temperature getLastInsertedTemperature();
  Temperature getLastInsertedTemperature(String id);
  Radiator getRadiator();
  void radiator();
  //for critical check
  int highCriticalTemp();
  int lowCriticalTemp();
  //external temperature
  double getExternalTemperature();


}
