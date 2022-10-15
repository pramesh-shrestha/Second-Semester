package ex2_TrafficLight_PropertyChangeSupport.Observer_Listener;

import ex2_TrafficLight_PropertyChangeSupport.Subject.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class  Truck
{
  public Truck(PropertyChangeSubject subject)
  {
    //this method will call reactToPropertyChange method whenever an event occurs
//    PropertyChangeListener listener = evt -> reactToPropertyChange(evt);
    //adding to the listener
    subject.addPropertyChangeListener(evt -> reactToPropertyChange(evt));
  }

  public void reactToPropertyChange(PropertyChangeEvent evt)
  {
    if("GREEN".equals(evt.getNewValue())) {
      System.out.println("Truck drives");
    } else if("YELLOW".equals(evt.getNewValue())) {
      if("RED".equals(evt.getOldValue())) {
        System.out.println("Truck turns engine on");
      } else {
        System.out.println("Truck slows down");
      }
    } else if("RED".equals(evt.getNewValue())) {
      System.out.println("Truck stops");
    }
  }
}
