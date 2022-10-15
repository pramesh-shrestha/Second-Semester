package ex1_TrafficLightNormalWay;

public class Test
{
  public static void main(String[] args)
  {
    Car car1 = new Car(1);
    Car car2 = new Car(2);
    Car car3 = new Car(3);
    Taxi taxi1 = new Taxi(1);
    TrafficLight trafficLight = new TrafficLight();
    trafficLight.addCar(car1);
    trafficLight.addCar(car2);
    trafficLight.addCar(car3);
    trafficLight.addTaxi(taxi1);
    try
    {
      trafficLight.start();
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
}
