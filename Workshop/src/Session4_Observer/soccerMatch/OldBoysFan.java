package Session4_Observer.soccerMatch;

import java.beans.PropertyChangeEvent;

public class OldBoysFan {
  public OldBoysFan(PropertyChangeSubject subject){
    subject.addPropertyChangeListener(this::reactToPropertyChange);
  }

  private void reactToPropertyChange(PropertyChangeEvent evt) {
    if(evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Old Boys fans: YEEAAH!");

    else if(evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Old Boys fans: BUUHHHH!");
  }

}
