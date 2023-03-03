package Session1_Thread.counter;

public class Thread0 extends Thread
{
  private Counter counter;
  private final int N = 500*10*10;
  private String name;

  public Thread0 (String name, Counter counter )
  {
    this.name = name;
    this.counter = counter;
  }

  public void run () {
    for (int i = 0; i < N; i++){
        counter.inc ();
      System.out.println (getName () + " finished: Counter.value = " +
          counter.value() + " " + i);
    }


  }
}
