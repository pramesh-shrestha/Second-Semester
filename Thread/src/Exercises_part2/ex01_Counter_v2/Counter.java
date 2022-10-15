//Exercise 1
//    Implement the above counter example, but with two counters, similar to the example shown in the slides.
//    Use Lock objects to synchronize the critical code.
//    Create a couple of threads to update the two counters (either a thread updates one or both counters, that’s up to you).
//    Verify the output is as expected.



package Exercises_part2.ex01_Counter_v2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int countA;
  private int countB;
  private Lock lockA = new ReentrantLock();
  private Lock lockB = new ReentrantLock();

  public Counter()
  {
    countA = 0;
    countB = 0;
  }

  public void updateCountA()
  {
    synchronized (lockA){
      countA++;
    }

  }
  public synchronized void updateCountB()
  {
    synchronized (lockB){
      countB++;
    }
  }

  public int getCountA()
  {
    synchronized (lockA){
      return countA;
    }

  }

  public int getCountB()
  {
    synchronized (lockB){
      return countB;
    }
  }
}
