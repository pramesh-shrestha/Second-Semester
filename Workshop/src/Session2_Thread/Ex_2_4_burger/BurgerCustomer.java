package Session2_Thread.Ex_2_4_burger;

public class BurgerCustomer implements Runnable {
  private BurgerBar burgerBar;
  private int burgerToEat;
  private String name;

  public BurgerCustomer(BurgerBar burgerBar, int burgerToEat, String name) {
    this.burgerBar = burgerBar;
    this.burgerToEat = burgerToEat;
    this.name = name;
  }

  @Override
  public void run() {
    while(true){
      burgerBar.eatBurger(name);
      try {
        Thread.sleep(15000);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
