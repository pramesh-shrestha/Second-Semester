//Exercise 3 – updating a number
//    Change exercise 1, so that each thread takes a parameter, which determines how many numbers/letters to print out.
//    Currently, it’s hardcoded to 10. You should be able to instantiate the threads similar to this:
//    Thread numPrint = new Thread ( new Numbers ( 57 ) ) ;
//    Thread letPrint = new Thread ( new Letters ( 33 ) ) ;

package Exercises_part1.ex3_updatingNumber;

public class Letters implements Runnable
{
  private int letterThread;

  public Letters(int letterThread)
  {
    this.letterThread = letterThread;
  }

  @Override public void run()
  {
    {
      for (int i = 0; i < letterThread; i++)
        System.out.println((char) (i + 97));
    }
  }
}
