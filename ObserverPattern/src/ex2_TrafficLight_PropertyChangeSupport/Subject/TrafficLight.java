package ex2_TrafficLight_PropertyChangeSupport.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements PropertyChangeSubject
{
  private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private int lightIndex = 2;
  private String currentLight;
  private PropertyChangeSupport support;

  //constructor
  public TrafficLight()
  {
    currentLight = lights[lightIndex];
    support = new PropertyChangeSupport(this);
  }

  public void start() throws InterruptedException
  {
    for (int i = 0; i < 10; i++)
    {
      String previousLight = "";
      Thread.sleep(2000);
      previousLight = currentLight;
      lightIndex = (lightIndex + 1) % 4;
      currentLight = lights[lightIndex];
      System.out.println("\nLight is " + currentLight);

      //notifying the listeners
      support.firePropertyChange("LightChanged",previousLight,currentLight);

      //for the van, we must make sure that trafficLight is firing those events mentioned in Van class
      support.firePropertyChange(currentLight, previousLight,currentLight);

    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {

    support.addPropertyChangeListener(listener);

  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    if(eventName == null || eventName.equals(""))
      addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    if(eventName ==null || eventName.equals(("")))
      removePropertyChangeListener(listener);
    else
      support.removePropertyChangeListener(eventName,listener);
  }
}
