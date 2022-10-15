//Exercise 0
//    Implement the counter increment exercise from last time:
//    A counter class containing a count field variable of type int. Include a method to increment the variable by one: count++;
//    A Runnable class with a reference to a counter class, which invokes the increment method 1.000.000 times.
//    At the end print out the count variable.
//    Create a Start class, instantiate a counter class, and two threads to increment the counter.
//    Verify that the count variable is not 2.000.000.
//
//    Synchronize the code so that you get the result, you expect.
//    Try both with synchronizing the method and using the synchronized block approach.


package Exercises_part2.ex0_Counter;

public class Counter
{
  private int count;

  public Counter()
  {
    count = 0;
  }

  public synchronized void update()
  {
    count++;
  }

  public int getCount()
  {
    return count;
  }


}
