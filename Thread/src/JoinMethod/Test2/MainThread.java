package JoinMethod.Test2;

public class MainThread
{
  public static void main(String[] args)
  {
    //This gives the reference of current thread
    Thread currentThread = Thread.currentThread();
    //The constructor call of ChildThread will initialize the field in ChildThread class.
    //It means the private field of ChildThread class has the reference of main thread.
    Thread thread = new Thread(new ChildThread(currentThread));
    thread.start();

    for (int i = 1; i < 5; i++)
    {
      try
      {
        Thread.sleep(1000);
        System.out.println("Main thread " + i);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
