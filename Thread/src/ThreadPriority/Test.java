package ThreadPriority;

public class Test implements Runnable
{

  @Override public void run()
  {
    System.out.println("Child thread");
    System.out.println(Thread.currentThread().getPriority());
   ;
  }

  public static void main(String[] args)
  {
    System.out.println(Thread.currentThread().getPriority());
    System.out.println("Main thread");

    Thread thread = new Thread(new Test());
    //setting the priority of child thread
    thread.setPriority(8);
    thread.start();


  }
}
