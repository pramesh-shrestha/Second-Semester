package ProducerConsumer;

public class Test
{
  public static void main(String[] args)
  {
    Buffer<Carrot> carrotBuffer = new BlockingQueue<>(20);
    Thread carrotPeeler = new Thread(new CarrotPeeler(carrotBuffer));
    Thread carrotEater1 = new Thread(new CarrotEater(carrotBuffer));
    Thread carrotEater2 = new Thread(new CarrotEater(carrotBuffer));

    carrotPeeler.start();
    carrotEater1.start();
    carrotEater2.start();

  }
}
