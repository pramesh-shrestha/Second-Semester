package Exercises_part1.ex5_sleep;

public class LambdaWay
{
  private int secs;

  public LambdaWay(int secs)
  {
    this.secs = secs;
  }
  Runnable lambda = () -> {
    for (int i = 1; i < 10; i++)
    {
      System.out.println(i);
      try
      {
        Thread.sleep(secs);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  };
  public static void main(String[] args)
  {
    LambdaWay lambdaWay = new LambdaWay(2000);
    lambdaWay.lambda.run();
  }
}
