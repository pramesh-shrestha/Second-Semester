package ex4_SoccerMatch;

import java.beans.PropertyChangeEvent;

public class ScoreBoard
{
  int dreamTeamTotalScore = 0;
  int oldBoysTotalScore = 0;
  public ScoreBoard(PropertyChangeSubject subject)
  {
    //using method reference
    subject.addPropertyChangeListener(this::reactToChange);
  }
  public void reactToChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("DreamTeamScore"))
    {
      System.out.println("Dream Team: " + evt.getNewValue());
      dreamTeamTotalScore = (int)evt.getNewValue(); //it must be cast to int as evt.getNewValue() is of Object data type
    }


    else if (evt.getPropertyName().equals("OldBoysScore"))
    {
      System.out.println("Old Boys: " + evt.getNewValue());
      oldBoysTotalScore = (int)evt.getNewValue();
    }
  }

  //getter

  public int getDreamTeamTotalScore()
  {
    return dreamTeamTotalScore;
  }

  public int getOldBoysTotalScore()
  {
    return oldBoysTotalScore;
  }
}
