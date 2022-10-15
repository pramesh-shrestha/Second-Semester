package ex4_Temperature.model;

public interface TemperatureModel
{
  void addTemperature(String id, double temperature);
  Temperature getLastInsertedTemperature();
  Temperature getLastInsertedTemperature(String id);
}
