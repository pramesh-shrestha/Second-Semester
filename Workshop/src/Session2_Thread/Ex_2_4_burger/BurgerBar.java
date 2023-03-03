package Session2_Thread.Ex_2_4_burger;

public class BurgerBar {
  private int numberOfBurgers;
  private int maxNumberBurgers;

  public BurgerBar(int maxNumberBurgers) {
    numberOfBurgers = 0;
    this.maxNumberBurgers = maxNumberBurgers;
  }

  public synchronized void makeBurger(String employeeName){
    while(numberOfBurgers >= maxNumberBurgers){
      try {
        System.out.println(employeeName + " is waiting to make burgers");
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    numberOfBurgers++;
    System.out.println(employeeName + " is preparing burgers");
    notifyAll();
  }

  public synchronized void eatBurger(String who){
    while(numberOfBurgers <= 0){
      try {
        System.out.println(who + " is waiting to eat burgers");
        wait();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    numberOfBurgers--;
    System.out.println(who+ " is ready to eat a burger (" + numberOfBurgers + " left) ");
    notifyAll();
  }

  public synchronized int getNumberOfBurgers() {
    return numberOfBurgers;
  }
}
