//Exercise 8 – Thread serialism
//    Create a Runnable class, the constructor should take two int parameters, e.g. x and y. The class should then print out the numbers from x to y.
//
//    In a main method create four instances of your Runnable class, and start Threads. One instance should print numbers from 0-25, the next 26-50, the next 51-75 and so on.
//    Are the numbers printed in ascending sequence?
//    Use the join functionality to make sure that the numbers printed are always in ascending sequence.
//    You may need to increase the ranges to e.g. 0-25000, 25000 – 50000, etc..


    package Exercises_part1.ex8_ThreadSerialism;

public class AscendingSequence implements Runnable
{
  private int x,y;

  public AscendingSequence(int x, int y)
  {
    this.x  = x;
    this.y = y;
  }

  @Override public void run()
  {
    for (int i = x; i <= y; i++)
    {
      try
      {
        Thread.sleep(1000);
        System.out.println(i);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      ;
    }
  }
}
