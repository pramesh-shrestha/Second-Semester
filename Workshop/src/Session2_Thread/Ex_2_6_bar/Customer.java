package Session2_Thread.Ex_2_6_bar;

public class Customer implements Runnable{
  private final Bar bar;

  public Customer(Bar bar) {
    this.bar = bar;
  }

  public void run() {
    while(bar.isOpen()) {
      Beer beer = bar.takeBeer();
      if (beer == null) break;
      System.out.println("Drinking " + beer);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Beer finished");
    }
    System.out.println("Customer going home");
  }
}
