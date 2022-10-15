package Exercises_part1.ex2_runStart;

public class HelloPrinter implements Runnable
{
  @Override public void run()
  {
    for (int i = 1; i < 50; i++)
    {
      System.out.println("Hello");
    }
  }
}
