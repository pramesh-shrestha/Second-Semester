package Session1_Thread.Ex_1_6;

public class Start {
  public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();
    Thread thread1 = new Thread(new CountIncrementer(counter));
    Thread thread2 = new Thread(new CountIncrementer(counter));
    thread1.start();
//    thread1.join();
    thread2.start();
    thread2.join();
  }
}
