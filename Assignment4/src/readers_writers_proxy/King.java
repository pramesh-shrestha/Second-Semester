package readers_writers_proxy;

import multiton.MultitonValuables;
import singleton.SingletonLog;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable{
  private TreasureRoomDoor treasureRoomDoor;
  private ArrayList<MultitonValuables> valuables;

  public King(TreasureRoomDoor treasureRoomDoor) {
    this.treasureRoomDoor = treasureRoomDoor;
    valuables = new ArrayList<>();
  }

  @Override
  public void run() {
    Random random = new Random();
    int targetForParty = 0;
    int collectedValue = 0;
    while(true){
      targetForParty = random.nextInt(100) + 50;
      int number = random.nextInt(5) + 1;
      treasureRoomDoor.acquireKingAccess();
      MultitonValuables multitonValuables = treasureRoomDoor.retrieve(number);
      valuables.add(multitonValuables);
      collectedValue += multitonValuables.getValueWorth();
      if(collectedValue >= targetForParty ||treasureRoomDoor.getTotalValuablesCount() < 2){
        break;
      } else {
        try {
          Thread.sleep(5);
        }
        catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
    treasureRoomDoor.releaseKingAccess();
    if(collectedValue >= targetForParty){
      SingletonLog.getInstance().addLog("King threw a party of worth " + collectedValue);
    } else {
      treasureRoomDoor.add(valuables);
      SingletonLog.getInstance().addLog("King cancelled the party because of not valuables in the Treasury");
    }
  }
}
