package Session4_Observer.birdWatcher;

import Session4_Observer.soccerMatch.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

public class BirdWatcher implements PropertyChangeListener {
  public BirdWatcher(PropertyChangeSubject subject) {
    subject.addPropertyChangeListener(this);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    int number = new Random().nextInt(3);
    if(evt.getPropertyName().equals("flash"))
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
