package CarrotPeelerV2;

public class Test
{
  public static void main(String[] args)
  {
    CarrotQueue carrotQueue = new CarrotQueue(10);
    Thread carrotPeeler = new Thread(new CarrotPeeler(carrotQueue));
    Thread carrotEater1 = new Thread(new CarrotEater(carrotQueue));

    carrotPeeler.start();
    carrotEater1.start();

  }
}
