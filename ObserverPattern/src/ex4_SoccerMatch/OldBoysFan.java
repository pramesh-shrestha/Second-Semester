package ex4_SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{
  public OldBoysFan(PropertyChangeSubject subject) //we can use reference of SoccerMatch as well because it implements PropertyChangeSubject
  {
    subject.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Old Boys fans: YEEAAH!");

    else if(evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Old Boys fans: BUUHHHH!");
  }
}
