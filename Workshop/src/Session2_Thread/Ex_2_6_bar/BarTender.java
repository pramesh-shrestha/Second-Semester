package Session2_Thread.Ex_2_6_bar;

public class BarTender implements Runnable{
  private Bar bar;

  public BarTender(Bar bar) {
    this.bar = bar;
  }

  @Override
  public void run() {
    while (bar.isOpen()){
      System.out.println("Bartender is serving beers.");
      bar.placeBeer(new Beer());
      System.out.println("Bartender placed a beer.");
      try {
        Thread.sleep(500);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
