package Session4_Observer.soccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Medic implements PropertyChangeListener
{
  public Medic(PropertyChangeSubject subject)
  {
    //adding the listener to the PropertyChangeSubject
    subject.addPropertyChangeListener(this); //this here means the object reference of the Medic classs
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("DreamTeamTackle") || evt.getPropertyName().equals("OldBoysTackle"))
      System.out.println("Medic runs towards the player to prevent serious injury.");
  }
}
