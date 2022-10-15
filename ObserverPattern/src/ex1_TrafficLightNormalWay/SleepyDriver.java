package ex1_TrafficLightNormalWay;

public class SleepyDriver
{
  private int id;
  private String previousLight;

  public SleepyDriver(int id)
  {
    this.id = id;
  }
  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("Sleepy driver " + id + " starts engine and drives");
    }
    else if ("YELLOW".equals(currentLight))
    {
      if ("RED".equals(previousLight))
      {
        System.out.println("Sleepy driver " + id + " doesn't do anything");
      }
      else
      {
        System.out.println("TrafficLightNormalWay.Car " + id + " slows down");
      }
    }
    else if ("RED".equals(currentLight))
    {
      System.out.println("TrafficLightNormalWay.Car " + id + " stops");
    }
    previousLight = currentLight;
  }

}
