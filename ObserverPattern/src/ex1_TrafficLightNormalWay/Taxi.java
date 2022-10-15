package ex1_TrafficLightNormalWay;

public class Taxi
{
  private int id;


  public Taxi(int id)
  {
    this.id = id;
  }
  public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
      {
      System.out.println("TrafficLightNormalWay.Taxi " + id + " drives");
     }

    else if ("RED".equals(currentLight))
      {
      System.out.println("TrafficLightNormalWay.Taxi " + id + " stops");
      }
  }
}
