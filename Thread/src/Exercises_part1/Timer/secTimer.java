package Exercises_part1.Timer;

public class secTimer implements Runnable
{
  private Timer timer;

  public secTimer(Timer timer)
  {
    this.timer = timer;
  }
  @Override public void run()
  {
    while(true)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      if(timer.getSec() == 60)
      {
        timer.setSec(0);
        timer.minCounter();

      }


      System.out.println(timer.getMin() + ":" +timer.getSec());
      timer.secCounter();

    }
  }
}
