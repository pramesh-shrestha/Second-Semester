package CarrotPeelerV2;

public class CarrotPeeler implements Runnable
{
  private CarrotQueue carrotQueue;

  public CarrotPeeler(CarrotQueue carrotQueue)
  {
    this.carrotQueue = carrotQueue;
  }

  @Override
  public void run()
  {
    while (true)
    {
      carrotQueue.peel(new Carrot());
    }
  }
}
