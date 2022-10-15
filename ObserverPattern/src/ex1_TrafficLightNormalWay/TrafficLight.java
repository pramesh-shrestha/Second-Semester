package ex1_TrafficLightNormalWay;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight
{
  List<Car> cars;
  List<Taxi> taxis;
  List<SleepyDriver> sleepyDrivers;
  List<Pedestrian> pedestrians;
  private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private int lightIndex = 2;
  private String currentLight;

  public TrafficLight()
  {
    currentLight = lights[2];
    cars = new ArrayList<>();
    taxis = new ArrayList<>();
    sleepyDrivers = new ArrayList<>();
    pedestrians = new ArrayList<>();
  }

  public void addCar(Car car)
  {
    cars.add(car);
    car.setLight(currentLight);
  }

  public void addTaxi(Taxi taxi)
  {
    taxis.add(taxi);
    taxi.setLight(currentLight);
  }

  public void start() throws InterruptedException
  {
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(2000);
      lightIndex = (lightIndex + 1) % 4;
      currentLight = lights[lightIndex];
      System.out.println("\nLight is " + currentLight);
      lightChanged();
    }
  }

  private void lightChanged()
  {
    for (Car car : cars)
    {
      car.setLight(currentLight);
    }
    for(Taxi taxi : taxis)
    {
      taxi.setLight(currentLight);
    }

    for (SleepyDriver sleepyDriver: sleepyDrivers)
    {
      sleepyDriver.setLight(currentLight);
    }

    for(Pedestrian pedestrian : pedestrians)
    {
      pedestrian.setLight(currentLight);
    }
  }
}
