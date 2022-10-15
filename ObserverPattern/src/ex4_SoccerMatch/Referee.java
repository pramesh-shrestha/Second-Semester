package ex4_SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Referee implements PropertyChangeListener
{
  public Referee(PropertyChangeSubject subject)
  {
    subject.addPropertyChangeListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("OldBoysTackle"))
      System.out.println("Referee gives Old Boys a yellow card for a rough tackle.");

    else if(evt.getPropertyName().equals("DreamTeamTackle"))
      System.out.println("Referee gives Dream Team a yellow card for a rough tackle.");
  }
}
