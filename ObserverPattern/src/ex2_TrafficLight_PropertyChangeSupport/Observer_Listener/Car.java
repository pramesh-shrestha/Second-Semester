package ex2_TrafficLight_PropertyChangeSupport.Observer_Listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener
{
  private int id;

  public Car(int id)
  {
    this.id = id;
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if("GREEN".equals(evt.getNewValue())) {
      System.out.println("Car " + id + " drives");
    } else if("YELLOW".equals(evt.getNewValue())) {
      if("RED".equals(evt.getOldValue())) {
        System.out.println("Car " + id + " turns engine on");
      } else {
        System.out.println("Car " + id + " slows down");
      }
    } else if("RED".equals(evt.getNewValue())) {
      System.out.println("Car " + id + " stops");
    }
  }
}
