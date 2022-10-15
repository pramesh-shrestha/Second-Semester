package ex5_BirdWatching.observer;

import ex5_BirdWatching.subject.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BlindBirdWatcher implements PropertyChangeListener
{
  public BlindBirdWatcher(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener(this);
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("whistle"))
      System.out.println("I can hear the Peacock whistling.");
  }
}
