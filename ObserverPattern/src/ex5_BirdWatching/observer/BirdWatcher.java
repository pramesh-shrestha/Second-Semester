package ex5_BirdWatching.observer;

import ex5_BirdWatching.subject.PropertyChangeSubject;
import java.beans.PropertyChangeEvent;
import java.util.Random;

public class BirdWatcher
{
  public BirdWatcher(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener(this::reactToChange);
  }

  public void reactToChange(PropertyChangeEvent event)
  {
    int number = new Random().nextInt(3);
    if(event.getPropertyName().equals("flash"))
    {
      if(number == 0)
        System.out.println("Ooh");

      else if(number == 1)
        System.out.println("How nice.");

      else
        System.out.println("Would you look at that.");
    }

  }
}
