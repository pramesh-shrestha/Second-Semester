package ex4_SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{
  public DreamTeamFan(SoccerMatch soccerMatch)
  {
    //Adding DreamTeamFan listener to the subject. When a constructor is created in main method, this listener will be added to the subject. 'this'
    //keyword means, an object of DreamTeamFan
    soccerMatch.addPropertyChangeListener(this);
  }
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Dream Team fans: YEEAAH!");

    else if(evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Dream Team fans: BUUHHHH!");


  }
}
