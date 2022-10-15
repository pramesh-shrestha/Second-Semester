package Exercises_part1.ex3_updatingNumber;

public class Test
{
  public static void main(String[] args)
  {
    Thread th1 = new Thread(new Letters(57));
    Thread th2 = new Thread(new Numbers(33));

    th1.start();
    th2.start();

  }
}
