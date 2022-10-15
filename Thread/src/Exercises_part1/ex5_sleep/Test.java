package Exercises_part1.ex5_sleep;

public class Test
{
  public static void main(String[] args)
  {
    Thread th =new Thread(new Sleep(1000));
    th.start();
  }
}
