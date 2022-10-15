package ex4_SoccerMatch;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject
{

	private String team0 = "Dream Team";
	private String team1 = "Old Boys";
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	private int dreamTeamNewScore = 0;
	private int oldBoysNewScore = 0;
	private int dreamTeamNewTackle = 0;
	private int oldBoysNewTackle = 0;


	public void startMatch() {
		System.out.println("Match starting \n\n");
		Random random = new Random();
		for(int i = 0; i < 90; i++) {

			int rand = random.nextInt(100);
			int whichTeam = random.nextInt(2);

			if(rand < 8) {
				// score goal
				scoreGoal(whichTeam);
			} else if(rand < 12) {
				// penalty
				roughTackle(whichTeam);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		System.out.println("\n\nMatch ended");
	}

	private void roughTackle(int whichTeam) {
		int oldBoysPreviousTackle;
		int dreamTeamPreviousTackle;
		if(whichTeam == 0) {
			System.out.println("Dream Team tackled.");
			//keeping track of previous tackle
			dreamTeamPreviousTackle = dreamTeamNewTackle;
			//incrementing the new tackle
			dreamTeamNewTackle++;
			support.firePropertyChange("DreamTeamTackle", dreamTeamPreviousTackle,dreamTeamNewTackle);

		} else {
			System.out.println("Old Boys Tackled");
			oldBoysPreviousTackle = oldBoysNewTackle;
			oldBoysNewTackle++;
			support.firePropertyChange("OldBoysTackle",oldBoysPreviousTackle,oldBoysNewTackle);
		}
	}

	private void scoreGoal(int whichTeam)
	{
		int dreamTeamPreviousScore;
		int oldBoysPreviousScore;
		if(whichTeam == 0) {
			System.out.println("Dream Team scored.");
			//keeping track of old score
			dreamTeamPreviousScore = dreamTeamNewScore;
			//incrementing the score
			dreamTeamNewScore++;
			support.firePropertyChange("DreamTeamScore", dreamTeamPreviousScore, dreamTeamNewScore);
		} else {
			System.out.println("Old Boys scored.");
			oldBoysPreviousScore = oldBoysNewScore;
			oldBoysNewScore++;
			support.firePropertyChange("OldBoysScore", oldBoysPreviousScore,oldBoysNewScore);
		}
	}

	@Override public void addPropertyChangeListener(
			PropertyChangeListener listener)
	{
		support.addPropertyChangeListener(listener);
	}

	@Override public void addPropertyChangeListener(String eventName,
			PropertyChangeListener listener)
	{
		support.addPropertyChangeListener(eventName,listener);
	}

	@Override public void removePropertyChangeListener(
			PropertyChangeListener listener)
	{
		support.removePropertyChangeListener(listener);
	}

	@Override public void removePropertyChangeListener(String eventName,
			PropertyChangeListener listener)
	{
		support.removePropertyChangeListener(eventName,listener);
	}
}
