package ex3_DoctorsWaitingRoom.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements PropertyChangeSubject, Runnable
{
  private PropertyChangeSupport support;
  public WaitingRoom()
  {
    support = new PropertyChangeSupport(this);
  }


  @Override public void run()
  {
    int newCount = -1;
    int oldCount = 0;


    while (true)
    {
      newCount++;
      support.firePropertyChange("Patient",oldCount, newCount);
      oldCount = newCount;

      try
      {
        Thread.sleep(1000);
        System.out.println("Ding");
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

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
    support.removePropertyChangeListener(eventName,listener);
  }


}
