package Exercises_part1.ex1_NumbersLetters;

public class PracticeThread
{
  public static void main(String[] args)
  {
    Numbers numbers = new Numbers();
    Thread thread1 = new Thread(numbers);
    Thread thread2 = new Thread(new Letters());
    thread1.start();
    thread2.start();
  }
}
