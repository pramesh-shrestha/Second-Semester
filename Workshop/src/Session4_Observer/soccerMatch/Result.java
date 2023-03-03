package Session4_Observer.soccerMatch;

public class Result implements Runnable
{
  private Thread resultThread;
  private ScoreBoard scoreBoard;

  public Result(ScoreBoard scoreBoard, Thread resultThread)
  {
    this.scoreBoard = scoreBoard;
    this.resultThread = resultThread;
  }

  @Override public void run()
  {
    try
    {
      resultThread.join();
      finalScore();
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
  public void finalScore()
  {
    int dreamTeam = scoreBoard.getDreamTeamTotalScore();
    int oldBoys = scoreBoard.getOldBoysTotalScore();
    System.out.println();
    System.out.println("Final Score");
    System.out.println("-----------");
    System.out.println("Dream Team: " + dreamTeam + "  " + "Old Boys: " + oldBoys);
    System.out.println();

    //checking condition for the winner
    if(dreamTeam > oldBoys)
      System.out.println("Dream Team Wins.");

    else if(oldBoys > dreamTeam)
      System.out.println("Old Boys Wins.");

    else
      System.out.println("Match Draw");
  }


}
