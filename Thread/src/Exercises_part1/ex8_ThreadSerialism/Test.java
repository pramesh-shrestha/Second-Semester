package Exercises_part1.ex8_ThreadSerialism;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    AscendingSequence ascendingSequence1 = new AscendingSequence(0,25);
    AscendingSequence ascendingSequence2 = new AscendingSequence(26,50);
    AscendingSequence ascendingSequence3 = new AscendingSequence(51,75);
    AscendingSequence ascendingSequence4 = new AscendingSequence(76,100);
    Thread thread1 = new Thread(ascendingSequence1);
    Thread thread2 = new Thread(ascendingSequence2);
    Thread thread3 = new Thread(ascendingSequence3);
    Thread thread4 = new Thread(ascendingSequence4);

    thread1.start();
    thread1.join();
    thread2.start();
    thread2.join();
    thread3.start();
    thread3.join();
    thread4.start();

  }
}
