//Exercise 2 – run() instead of start()
//    Create two classes, which implement Runnable. One should print out “hi” 1000 times. The other should print out “hello” 1000 times.
//    Start two threads from a main method and check the output. Do this a few times. You should see, that sometimes “hi” and “hello” are
//    printed alternatively, like the exercise above.
//    Now change the code in the main method to just instantiate your two Runnable classes, and call the run() method on both. Something like:
//    HiPrinter hi = new HiPrinter();
//    HelloPrinter hello = new HelloPrinter();
//    hi.run();
//    hello.run();

package Exercises_part1.ex2_runStart;

public class HiPrinter implements Runnable
{
  @Override public void run()
  {
    for (int i = 1; i < 50; i++)
    {
      System.out.println("Hi");
    }
  }
}
