//Exercise 2
//    Change the counter example, so this time it looks like slide 37, and you use the tryLock() method.
//    Just do it like the slide. You should see that once again, we don’t reach 2.000.000, because not all the time can the lock be acquired.
//    Try to fix it, so if the lock cannot be obtained, you wait 1 ms and try again.




package Exercises_part2.ex2_Counter_v3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int count;

  private Lock lock = new ReentrantLock();


  public Counter()
  {
    count = 0;

  }

  public void updateCount()
  {
    if(lock.tryLock()) //Acquires lock if the boolean is true
    {
      count++;
      lock.unlock();
    }
    else
    {
      try
      {
        Thread.sleep(1);
        updateCount();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
}

  public int getCount()
  {
    synchronized (lock){
      return count;
    }

  }
}
