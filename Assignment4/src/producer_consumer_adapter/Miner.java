package producer_consumer_adapter;

import multiton.MultitonValuables;

import java.util.Random;

public class Miner implements Runnable{
  //because deposit is a shared resource between Miner and Valuable Transporter, so Miner has reference to Deposit
  private DepositValuables<MultitonValuables>  depositValuables;

  public Miner(DepositValuables<MultitonValuables> depositValuables) {
    this.depositValuables = depositValuables;
  }

  private void sleep(){
    try {
      Thread.sleep(5000);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void run() {
    Random random  = new Random();
    while(true){
      int value = random.nextInt(5) + 1;

      if(value == 1){
        depositValuables.add(MultitonValuables.item("Diamond"));
      } else if(value == 2){
        depositValuables.add(MultitonValuables.item("GoldNugget"));
      } else if(value == 3){
        depositValuables.add(MultitonValuables.item("Jewel"));
      } else if(value == 4){
        depositValuables.add(MultitonValuables.item("Ruby"));
      } else {
        depositValuables.add(MultitonValuables.item("WoodenCoin"));
      }
      System.out.println(depositValuables.getSize() + "size");
      System.out.println(depositValuables.getCapacity() + "capacity");
//      sleep();
    }
  }
}
