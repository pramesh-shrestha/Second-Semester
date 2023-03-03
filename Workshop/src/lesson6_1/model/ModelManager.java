package lesson6_1.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private Converter converter;
  private PropertyChangeSupport support;
  public ModelManager()
  {
    this.converter = new Converter();
    support = new PropertyChangeSupport(this);
  }

  @Override public synchronized String convert(String source)
  {
    String reply = converter.toUpperCase(source);
    addLog("Converting: " + source);
    support.firePropertyChange("added", null, reply);
    return reply;
  }

  @Override public synchronized void addLog(String log)
  {
    String logValue = converter.getLogSize() + ": " + log;
    converter.addLog(logValue);
  }


  @Override public ArrayList<String> getLogs()
 {
  return converter.getLogList();
 }

  @Override
  public void addListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
      support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName,listener);
  }
}
