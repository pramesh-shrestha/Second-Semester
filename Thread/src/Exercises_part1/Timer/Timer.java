package Exercises_part1.Timer;

public class Timer
{
  private int sec = 0;
  private int min = 0;

  public void secCounter()
  {
    if( sec < 60)
      sec++;
  }

  public void minCounter()
  {
    if(min < 60)
      min++;
  }

  public int getSec()
  {
    return sec;
  }

  public int getMin()
  {
    return min;
  }

  public void setSec(int sec)
  {
    this.sec = sec;
  }
}
