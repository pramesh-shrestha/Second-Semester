package ProducerConsumer;

public class CarrotEater implements Runnable
{
  private Buffer<Carrot> carrotBuffer;

  public CarrotEater(Buffer<Carrot> carrotBuffer)
  {
    this.carrotBuffer = carrotBuffer;
  }

  @Override
  public void run()
  {
    while (true)
    {
      carrotBuffer.take();
    }
  }
}
