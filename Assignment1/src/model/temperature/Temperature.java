package model.temperature;

import model.temperature.DateTime;

public class Temperature
{
   private String id;
   private double value;
   private DateTime time;


   public Temperature(String id, double value)
   {
      this.id = id;
      this.value = value;
      time = new DateTime();
   }
   public double getValue()
   {
      return value;
   }



   public String getId() { return id;}
   public DateTime getTime()
   {
      return time;
   }

   public String toString()
   {
      return String.format("%.1f",value);
   }
}
//