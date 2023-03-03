package Session2_Thread.Ex_2_3_1;

public class Start {
  public static void main(String[] args) {
    Thermometer thermometer1 = new Thermometer("t1", 15, 1);
    Thermometer thermometer2 = new Thermometer("t2", 15, 7);
    Thread thread1 = new Thread(thermometer1);
    Thread thread2 = new Thread(thermometer2);
    thread1.start();
    thread2.start();
  }
}
