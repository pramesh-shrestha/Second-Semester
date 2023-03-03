package Session2_Thread.Ex_2_4_burger;

public class Start {
  public static void main(String[] args) {
    BurgerBar burgerBar = new BurgerBar(30);
    BurgerBarEmployee employee1 = new BurgerBarEmployee(burgerBar, "John");
    BurgerBarEmployee employee2 = new BurgerBarEmployee(burgerBar, "Rocky");

    BurgerCustomer[] customers = {
        new BurgerCustomer(burgerBar, 1, "Rohit"),
        new BurgerCustomer(burgerBar, 2, "Manisha"),
        new BurgerCustomer(burgerBar, 2, "Apurva"),
        new BurgerCustomer(burgerBar, 2, "Rajip"),
        new BurgerCustomer(burgerBar, 1, "Suhani")
    };

    new Thread(employee1).start();
    new Thread(employee2).start();

    for (BurgerCustomer customer : customers) {
      new Thread(customer).start();
    }
  }
}
