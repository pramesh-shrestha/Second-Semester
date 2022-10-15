package Exercises_part2.ex5_ExtrachallengeBeer;

import java.util.ArrayList;

public class Test
{
  public static void main(String[] args)
  {
    Bar bar = new Bar(true);
    Beer beer = new Beer();
    Thread currentThread = Thread.currentThread();

    Bartender bartender1 = new Bartender(bar,beer);
    Bartender bartender2 = new Bartender(bar,beer);
    Customer customer1 = new Customer(bar);
    Customer customer2 = new Customer(bar);
    Customer customer3 = new Customer(bar);
    Customer customer4 = new Customer(bar);
    Customer customer5 = new Customer(bar);

    Thread barThread = new Thread(bar);

    Thread barTenderThread1 = new Thread(bartender1);
    Thread barTenderThread2 = new Thread(bartender2);

    Thread customerThread1 = new Thread(customer1);
    Thread customerThread2 = new Thread(customer2);
    Thread customerThread3 = new Thread(customer3);
    Thread customerThread4 = new Thread(customer4);
    Thread customerThread5 = new Thread(customer5);

    barTenderThread1.start();
    barTenderThread2.start();
    customerThread1.start();
    customerThread2.start();
    customerThread3.start();
    customerThread4.start();
    customerThread5.start();
    barThread.start();

  }
}
