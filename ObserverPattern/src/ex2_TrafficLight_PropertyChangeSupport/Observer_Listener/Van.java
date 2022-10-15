package ex2_TrafficLight_PropertyChangeSupport.Observer_Listener;

import ex2_TrafficLight_PropertyChangeSupport.Subject.TrafficLight;
import ex4_SoccerMatch.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;

public class Van
{
  public Van(TrafficLight subject)
  {
    //using lambda
    subject.addPropertyChangeListener("GREEN", this::reactToGreen);
    //using shortcut to lambda
    subject.addPropertyChangeListener("RED", this::reactToRed);
    subject.addPropertyChangeListener("YELLOW",this::reactToYellow);
  }

  public void reactToRed(PropertyChangeEvent event)
  {
    System.out.println("Van stops");
  }
  public void reactToYellow(PropertyChangeEvent event)
  {
    if("RED".equals(event.getOldValue())) {
      System.out.println("Van turns engine on");
    } else {
      System.out.println("Van slows down");
    }
  }
  public void reactToGreen(PropertyChangeEvent event)
  {
    System.out.println("Van drives");
  }
}
