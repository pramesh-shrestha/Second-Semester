package Exercises_part1.ex6_Bear;

public class PokingMan implements Runnable
{
  private  Thread bearThread;
  public PokingMan(Thread bearThread)
  {
    this.bearThread = bearThread;
  }

  @Override public void run()
  {
    //This interrupts the thread that is in sleep mode for 5secs, and therefore executes catch block
    bearThread.interrupt();

  }
}
