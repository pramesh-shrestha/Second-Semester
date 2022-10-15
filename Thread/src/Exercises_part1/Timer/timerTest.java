package Exercises_part1.Timer;

public class timerTest
{
  public static void main(String[] args)
  {
    //creating a thread of secTimer
    Thread secThread = new Thread(new secTimer(new Timer()));

    secThread.start();
  }
}
