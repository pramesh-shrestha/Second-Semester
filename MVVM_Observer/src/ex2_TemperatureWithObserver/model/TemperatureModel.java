package ex2_TemperatureWithObserver.model;

public interface TemperatureModel extends PropertyChangeSubject
{
  void addTemperature(String id, double temperature);
  Temperature getLastInsertedTemperature();
  Temperature getLastInsertedTemperature(String id);
}
