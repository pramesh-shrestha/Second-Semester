package DaemonThread;

public class Test implements Runnable
{
  @Override public void run()
  {
    if(Thread.currentThread().isDaemon())
      System.out.println("Daemon thread");
    else
      System.out.println("Child thread");
  }

  public static void main(String[] args)
  {
    System.out.println("Main thread");

    //creating a thread
    Test test = new Test();
    Thread thread = new Thread(test);

    //converting the thread to a daemon thread
    thread.setDaemon(true);

    //starting a thread
    thread.start();
  }
}
