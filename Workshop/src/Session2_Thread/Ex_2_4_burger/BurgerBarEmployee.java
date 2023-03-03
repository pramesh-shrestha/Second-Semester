package Session2_Thread.Ex_2_4_burger;


public class BurgerBarEmployee implements Runnable {
  private BurgerBar burgerBar;
  private String name;

  public BurgerBarEmployee(BurgerBar burgerBar, String name) {
    this.burgerBar = burgerBar;
    this.name = name;
  }

  @Override
  public void run() {
    while (true) {
      burgerBar.makeBurger(name);
      try {
        Thread.sleep(3000);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
