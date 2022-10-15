package Exercises_part2.ex5_ExtrachallengeBeer;

public class Customer implements Runnable
{
  private Bar bar;


  public Customer(Bar bar)
  {
    this.bar  = bar;
  }

  @Override public void run()
  {
      while(bar.isBarOpen())
      {
        try
        {
          Thread.sleep(5000);
          bar.takeBeer();
          System.out.println("Customer bought a beer.");
        }
        catch (InterruptedException e)
        {
          System.out.println("Customer is leaving");
        }
      }



  }

}
