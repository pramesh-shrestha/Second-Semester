package ex1_TrafficLightNormalWay;

public class Pedestrian
{
  private int id;
  private String previousLight;

  public Pedestrian(int id)
  {
    this.id = id;
  }
  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("TrafficLightNormalWay.Pedestrian " + id + " waits");
    }
    else if ("YELLOW".equals(currentLight))
    {
      if ("RED".equals(previousLight))
      {
        System.out.println("TrafficLightNormalWay.Pedestrian " + id + " gets ready to cross");
      }
      else
      {
        System.out.println("TrafficLightNormalWay.Pedestrian " + id + " runs faster across the road");
      }
    }
    else if ("RED".equals(currentLight))
    {
      System.out.println("TrafficLightNormalWay.Pedestrian " + id + " crosses the road");
    }
    previousLight = currentLight;
  }
}
