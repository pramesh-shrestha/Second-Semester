package model.mediator;

import model.outdoor.ExternalTemperature;
import model.radiator.*;
import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private Radiator radiator;
  private ExternalTemperature externalTemperature;
  private PropertyChangeSupport support;


  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    support = new PropertyChangeSupport(this);
    radiator = new Radiator(new OffState());
    externalTemperature = new ExternalTemperature();
  }
  /**
   * The function adds a temperature to the list of temperatures and fires a
   * property change event to the listeners
   *
   * @param id the id of the temperature sensor
   * @param value the value of the temperature
   */
  @Override
  public void addTemperature(String id, double value)
  {

    Temperature temperature = new Temperature(id,value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    support.firePropertyChange("added", old,temperature.getValue());


    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature);
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


  /**
   * > The function `radiator()` is called when the radiator changes state. It gets
   * the current state of the radiator and fires a property change event to the
   * `support` object
   */
  public void radiator()
  {
    int currentPosition = radiator.getCurrentState().getPower();
    support.firePropertyChange("powerPosition",null, currentPosition );
  }


  @Override
  public Radiator getRadiator()
  {
    return radiator;
  }

  @Override
  public int highCriticalTemp()
  {
    return temperatureList.getHighCriticalTemp();
  }

  @Override
  public int lowCriticalTemp()
  {
    return temperatureList.getLowCriticalTemp();
  }

  //external temperature
  @Override public double getExternalTemperature()
  {
    return externalTemperature.externalTemperature(0,-30,40);
  }

  /**
   * If the name is null or empty, add the listener to the list of listeners that
   * will be notified of all property changes. Otherwise, add the listener to the
   * list of listeners that will be notified of the property change with the given
   * name.
   *
   * @param name The name of the property to listen for changes on.
   * @param listener The listener to add.
   */
  @Override
  public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(name, listener);
  }

  /**
   * > Adds a PropertyChangeListener to the listener list
   *
   * @param listener The PropertyChangeListener to be added
   */
  @Override
  public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);

  }

  /**
   * If the name is null or empty, remove the listener from the list of all
   * listeners. Otherwise, remove the listener from the list of listeners for the
   * specified property
   *
   * @param name The name of the property to listen for.
   * @param listener The listener to remove.
   */
  @Override
  public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if(name.equals("") || name == null)
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(name, listener);
  }

  /**
   * Remove a listener from the list of listeners that are notified when a property
   * changes.
   *
   * @param listener The listener to remove.
   */
  @Override
  public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
