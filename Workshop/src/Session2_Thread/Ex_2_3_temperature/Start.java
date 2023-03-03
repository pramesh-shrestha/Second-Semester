package Session2_Thread.Ex_2_3_temperature;

public class Start {
  public static void main(String[] args) {
    Thermometer thermometer = new Thermometer("t1", 15);
    Thread thread = new Thread(thermometer);
    thread.start();
  }
}
