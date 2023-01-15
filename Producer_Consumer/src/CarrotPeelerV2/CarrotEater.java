package CarrotPeelerV2;

public class CarrotEater implements Runnable
{
  private CarrotQueue carrotQueue;

  public CarrotEater(CarrotQueue carrotQueue)
  {
    this.carrotQueue = carrotQueue;
  }

  @Override
  public void run()
  {
    while (true)
    {
      carrotQueue.eat();
    }
  }
}
