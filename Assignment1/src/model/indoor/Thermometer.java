package model.indoor;

import model.mediator.TemperatureModel;

public class Thermometer implements Runnable
{
  private double t;
  private String id;
  private int d;
  private TemperatureModel temperatureModel;

  public Thermometer(TemperatureModel temperatureModel, String id, double t, int d)
  {
    this.temperatureModel = temperatureModel;
    this.id = id  ;
    this.t = t;
    this.d = d;
  }
  /**
   * Calculating the temperature measured in one of two locations.
   * This includes a term from a heater (depending on location and
   * heaters power), and a term from an outdoor heat loss.
   * Values are only valid in the outdoor temperature range [-20; 20]
   * and when s, the number of seconds between each measurements are
   * between 4 and 8 seconds.
   *
   * @param t  the last measured temperature
   * @param p  the heaters power {0, 1, 2 or 3} where 0 is turned off,
   *    1 is low, 2 is medium and 3 is high
   * @param d  the distance between heater and measurements {1 or 7}
   *    where 1 is close to the heater and 7 is in the opposite corner
   * @param t0 the outdoor temperature (valid in the range [-20; 20])
   * @param s the number of seconds since last measurement [4; 8]
   * @return the temperature
   */
  public double temperature(double t,int p, int d, double t0,int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  @Override public void run()
  {
    while(true){
      double externalTemp = temperatureModel.getExternalTemperature();
      int power = temperatureModel.getRadiator().getCurrentState().getPower();
      t = temperature(t, power, d, externalTemp, 4);
      temperatureModel.addTemperature(id, t);
      try{
        Thread.sleep(2000);
      }
      catch (InterruptedException e){
      }
    }
  }
}
