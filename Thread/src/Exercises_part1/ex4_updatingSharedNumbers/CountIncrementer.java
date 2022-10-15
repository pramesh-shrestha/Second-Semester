package Exercises_part1.ex4_updatingSharedNumbers;

public class CountIncrementer implements Runnable
{
  private Counter counter;

  public CountIncrementer(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000000; i++)
    {
      synchronized (counter){
        counter.update();
      }
    }
    System.out.println(counter.getCount());


//    if(counter.getCount() == 1000000)
//      System.out.println("Verified");

  }


}
