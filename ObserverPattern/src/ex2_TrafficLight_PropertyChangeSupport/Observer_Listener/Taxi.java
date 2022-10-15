package ex2_TrafficLight_PropertyChangeSupport.Observer_Listener;

import ex2_TrafficLight_PropertyChangeSupport.Subject.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class   Taxi
{
  //anonymous implementation of the interface
  public Taxi(PropertyChangeSubject subject)
  {
    PropertyChangeListener listener = new PropertyChangeListener()
    {
      //this method will call reactToPropertyChange method whenever an event occurs
      @Override public void propertyChange(PropertyChangeEvent evt)
      {
        reactToPropertyChange(evt);
      }
    };
    //adding to the listener
    subject.addPropertyChangeListener(listener);
  }

   public void reactToPropertyChange(PropertyChangeEvent evt)
  {
      if ("GREEN".equals(evt.getNewValue()))
      {
        System.out.println("Taxi drives");
      }

      else if ("RED".equals(evt.getNewValue()))
      {
        System.out.println("Taxi stops");
      }
  }
}
