package Session4_Observer.soccerMatch;

import java.beans.PropertyChangeEvent;

public class DreamTeamFan {
  public DreamTeamFan(PropertyChangeSubject subject){
    subject.addPropertyChangeListener((evt) -> reactToPropertyChange(evt));
  }

  private void reactToPropertyChange(PropertyChangeEvent evt) {
    if(evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Dream Team fans: YEEAAH!");

    else if(evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Dream Team fans: BUUHHHH!");
  }

}
