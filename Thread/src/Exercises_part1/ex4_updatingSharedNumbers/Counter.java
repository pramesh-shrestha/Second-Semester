//Exercise 4 – Updating a shared number
//Create a class, call it Counter, with a single private field variable of type int. You can call the int field “count”.
//    It should be initialized to 0 in the constructor of Counter.
//Create a method, which when called will increment the int with 1, i.e. “count++;”.
//Create a method to get the count variable, i.e. “return count;”
//
//Create a Runnable class (a class implementing the Runnable interface), you can e.g. call it CountIncrementer,
//    which takes a reference to your class with the counter (an argument for the constructor of CountIncrementer)
//CounterIncrementer ci = new CounterIncrementer(counter);
//
//In the run() method of CounterIncrementer, you call the update method 1.000.000 times, in a for loop, so that the ‘count’
//    variable in Counter is incremented. When the for-loop is done, get the count variable, and print it out.
//Now create a Start class with a main method. Instantiate the Counter class, instantiate one instance of CountIncrementer, and start the Thread.
//Verify that the number printed out is 1.000.000.
//Change the code so that two CounterIncrementer threads are created and started.
//Two threads will now both increment the count variable 1.000.000 times. We would expect the printed result to be 2.000.000.
//    Is that always so? Or does the number sometimes differ from 2.000.000?
//This exercise is to peek your curiosity. We’ll discuss this next time.

package Exercises_part1.ex4_updatingSharedNumbers;

public class Counter
{
  private int count;

  public Counter()
  {
    count = 0;
  }

  public void update()
  {
    count++;
  }

  public int getCount()
  {
    return count;
  }

}
