package Exercises_part1.ex2_runStart;

public class Test
{
  public static void main(String[] args)
  {
    Thread th1 = new Thread(new HiPrinter());
    Thread th2 = new Thread(new HelloPrinter());

    th1.start();
    th2.start();
  }
}
