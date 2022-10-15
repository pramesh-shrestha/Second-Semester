package ex2_TemperatureWithObserver.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport support;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    support = new PropertyChangeSupport(this);
  }
  @Override
  public void addTemperature(String id, double value)
  {

    Temperature temperature = new Temperature(id,value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    support.firePropertyChange("added", old,temperature.getValue());


    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
    }
  }

  @Override
  public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override
  public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);

  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
