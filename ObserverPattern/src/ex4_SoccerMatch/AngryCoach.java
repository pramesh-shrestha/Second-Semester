package ex4_SoccerMatch;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoach
{
  public AngryCoach(PropertyChangeSubject subject)
  {
    //using method reference(could also use lambda expression instead or just do it normal way by implementing the PropertyChangeListener interface)
    subject.addPropertyChangeListener(this::reactToChange);
  }

  public void reactToChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Old Boys Coach cheers!");

    else if (evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Dream Team Coach cheers!");

    else if (evt.getPropertyName().equals("OldBoysTackle"))
      System.out.println("Dream Team Coach yells at the referee.");

    else if (evt.getPropertyName().equals("DreamTeamTackle"))
      System.out.println("Old Boys Coach yells at the referee.");
  }

}
