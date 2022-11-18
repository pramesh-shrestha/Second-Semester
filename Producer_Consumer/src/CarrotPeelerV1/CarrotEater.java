package CarrotPeelerV1;

public class CarrotEater implements Runnable
{
  private Buffer<Carrot> carrotBuffer;

  public CarrotEater(Buffer<Carrot> carrotBuffer)
  {
    this.carrotBuffer = carrotBuffer;
  }

  @Override
  public synchronized void run()
  {
    while (true)
    {
      carrotBuffer.take();
    }
  }
}
