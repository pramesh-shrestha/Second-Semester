package Exercises_part1.ex1_NumbersLetters;

public class Letters implements Runnable
{
  public void run()
  {
    for (int i = 0; i < 5; i++)
      System.out.println((char) (i + 97));
  }

}
