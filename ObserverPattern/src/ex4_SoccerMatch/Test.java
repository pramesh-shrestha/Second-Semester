package ex4_SoccerMatch;

public class Test
{
  public static void main(String[] args)
  {
    SoccerMatch soccerMatch = new SoccerMatch();
    DreamTeamFan dreamTeamFan = new DreamTeamFan(soccerMatch);
    OldBoysFan oldBoysFan = new OldBoysFan(soccerMatch);
    //we can avoid the left side as we don't use the reference for anything
    new AngryCoach(soccerMatch);
    new Referee(soccerMatch);
    ScoreBoard scoreBoard = new ScoreBoard(soccerMatch);
    new Medic(soccerMatch);

    //assigning the reference of the main thread for the Result class
    Thread mainThread = Thread.currentThread();
    Result result = new Result(scoreBoard,mainThread);
    Thread resultThread = new Thread(result);
    resultThread.start();

//    soccerMatch.addPropertyChangeListener(dreamTeamFan); //We don't need to do these if we add event listener direclty in the constructor
//    soccerMatch.addPropertyChangeListener(oldBoysFan);

    soccerMatch.startMatch();
  }
}
