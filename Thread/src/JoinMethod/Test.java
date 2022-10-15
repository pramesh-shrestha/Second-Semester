package JoinMethod;

//Run the child thread first and then main thread using join() method
public class Test implements Runnable
{

  @Override public void run()
  {
    try
    {
      for (int i = 1; i <= 5; i++)
      {
        System.out.println("Child thread" + i);

        Thread.sleep(1000);
      }
    }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
  }

  public static void main(String[] args)
  {
    Test t = new Test();
    Thread thread = new Thread(t);
    thread.start();

    try
    {
      thread.join();
      //It means the main thread is waiting for Test thread to finish executing first.
      // The reference should be the one from Test thread that calls the join method.
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    try
    {
      for (int i = 1; i <= 5; i++)
      {
        System.out.println("Main thread" + i);

        Thread.sleep(1000);

      }
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }

  }
}
