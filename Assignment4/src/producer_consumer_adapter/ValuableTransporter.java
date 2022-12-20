package producer_consumer_adapter;

import multiton.MultitonValuables;
import readers_writers_proxy.TreasureRoomDoor;
import singleton.SingletonLog;

import java.util.ArrayList;
import java.util.Random;

public class ValuableTransporter implements Runnable{
  private DepositValuables<MultitonValuables> depositValuables;
  private int targetWorth;
  int totalWorth = 0;
  private TreasureRoomDoor treasureRoomDoor;


  public ValuableTransporter(DepositValuables<MultitonValuables> depositValuables, int targetWorth, TreasureRoomDoor treasureRoomDoor) {
    this.depositValuables = depositValuables;
    this.targetWorth = targetWorth;
    this.treasureRoomDoor = treasureRoomDoor;
  }

  private void sleep(){
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void run() {
    ArrayList<MultitonValuables> valuables = new ArrayList<>();
    while(true){
      MultitonValuables items = depositValuables.take();
      valuables.add(items);
      SingletonLog.getInstance().addLog(items.getValueWorth() + " worth of valuables added to the deposit.");
      totalWorth += items.getValueWorth();

      if(totalWorth >= targetWorth){
        SingletonLog.getInstance().addLog("Total worth of valuables exceeds the target worth.");
        SingletonLog.getInstance().addLog(Thread.currentThread().getName() + " is transporting valuables worth " + totalWorth);
        treasureRoomDoor.acquireTransporterAccess();
        treasureRoomDoor.add(valuables);
        treasureRoomDoor.releaseTransporterAccess();
        sleep();
        valuables = new ArrayList<>();
        totalWorth = 0;
      }
    }
  }
}
