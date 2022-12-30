package ProducerConsumer;

public class CarrotPeeler implements Runnable
{
  private Buffer<Carrot> carrotBuffer;

  public CarrotPeeler(Buffer<Carrot> carrotBuffer)
  {
    this.carrotBuffer = carrotBuffer;
  }

  @Override
  public void run()
  {
    while (true)
    {
      carrotBuffer.put(new Carrot());
    }
  }
}
