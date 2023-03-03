package Session4_Observer.birdWatcher;

import Session4_Observer.soccerMatch.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;

public class BlindBirdWatcher {

  public BlindBirdWatcher(PropertyChangeSubject subject) {
    subject.addPropertyChangeListener(this::reactToBehaior);
  }

  private void reactToBehaior(PropertyChangeEvent evt) {
    if(evt.getPropertyName().equals("whistle"))
      System.out.println("I can hear the Peacock whistling.");
  }
}
