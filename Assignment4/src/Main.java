import producer_consumer_adapter.Deposit;
import producer_consumer_adapter.DepositValuables;
import producer_consumer_adapter.Miner;
import producer_consumer_adapter.ValuableTransporter;
import readers_writers_proxy.*;

public class Main {
  public static void main(String[] args) {
    DepositValuables valuables = new Deposit(50);
    TreasureRoomDoor treasureRoomDoor = new TreasureRoomGuardsman(new TreasureRoom());
    Miner miner1 = new Miner(valuables);
    Miner miner2 = new Miner(valuables);
    Miner miner3 = new Miner(valuables);
    ValuableTransporter transporter = new ValuableTransporter(valuables,150,treasureRoomDoor);
    ValuableTransporter transporter2 = new ValuableTransporter(valuables,150,treasureRoomDoor);
    ValuableTransporter transporter3 = new ValuableTransporter(valuables,150,treasureRoomDoor);
    King king = new King(treasureRoomDoor);
    Accountant accountant = new Accountant(treasureRoomDoor);


    Thread thread1 = new Thread(miner1);
    thread1.setName("Miner1");
    Thread thread2 = new Thread(miner2);
    thread2.setName("Miner2");
    Thread thread3 = new Thread(miner3);
    thread3.setName("Miner3");
    Thread thread4 = new Thread(transporter);
    thread4.setName("Transporter1");
    Thread thread5 = new Thread(king);
    thread5.setName("King");
    Thread thread6 = new Thread(accountant);
    thread6.setName("Accountant");
    Thread thread7 = new Thread(transporter2);
    thread7.setName("Transporter2");
    Thread thread8 = new Thread(transporter3);
    thread8.setName("Transporter3");


    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    thread6.start();
    thread7.start();
    thread8.start();


  }
}