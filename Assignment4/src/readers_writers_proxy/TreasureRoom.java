package readers_writers_proxy;

import multiton.MultitonValuables;

import java.util.ArrayList;

public class TreasureRoom implements TreasureRoomDoor {
  private ArrayList<MultitonValuables> valuables;
  private int activeAccountant = 0;
  private boolean king = false;
  private int waitingTransporter = 0;
  private int activeTransporter = 0;
  private int diamondCount = 0;
  private int jewelCount = 0;
  private int rubyCount = 0;
  private int woodenCoin = 0;
  private int goldNugget = 0;
  private int treasureWorth = 0;



  public TreasureRoom() {
    valuables = new ArrayList<>();
  }

  @Override
  public synchronized void add(ArrayList<MultitonValuables> gems) {
    for (int i = 0; i < gems.size(); i++) {
      if (gems.get(i).equals("Diamond")) {
        diamondCount++;
      }
      else if (gems.get(i).equals("Jewel")) {
        jewelCount++;
      }
      else if (gems.get(i).equals("Ruby")) {
        rubyCount++;
      }
      else if (gems.get(i).equals("WoodenCoin")) {
        woodenCoin++;
      }
      else if (gems.get(i).equals("GoldNugget")) {
        goldNugget++;
      }
      int value = valuables.get(i).getValueWorth();
      treasureWorth += value;
      valuables.add(gems.get(i));
    }
  }

  @Override
  public synchronized MultitonValuables retrieve(int choice) {
    MultitonValuables multitonValuable = null;
    while(valuables.size() <= 2){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
      if (choice == 1){
        multitonValuable = MultitonValuables.item("Diamond");
        diamondCount--;
      }
      else if (choice == 2) {
        multitonValuable = MultitonValuables.item("Jewel");
        jewelCount--;
      }
      else if (choice == 3) {
        multitonValuable = MultitonValuables.item("Ruby");
        rubyCount--;
      }
      else if (choice == 4) {
        multitonValuable = MultitonValuables.item("WoodenCoin");
        woodenCoin--;
      }
      else if (choice == 5) {
        multitonValuable = MultitonValuables.item("GoldNugget");
        goldNugget--;
      }
      return multitonValuable;
  }

  @Override
  public synchronized int look() {
    return getTreasureWorth();
  }

  @Override
  public synchronized void acquireRead() {
    while(king || activeTransporter > 0 || waitingTransporter > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    activeAccountant++;
  }

  @Override
  public synchronized void releaseRead() {
    activeAccountant--;
    if(activeAccountant == 0){
      notifyAll();
    }
  }

  @Override
  public synchronized void acquireTransporterAccess() {
    waitingTransporter++;
    while(king || activeAccountant > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingTransporter--;
    activeTransporter++;
  }

  @Override
  public synchronized void releaseTransporterAccess() {
    activeTransporter--;
    notifyAll();
  }

  @Override
  public synchronized void acquireKingAccess() {
    while(activeAccountant > 0 || activeTransporter > 0){
      try {
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    king = true;
  }

  @Override
  public synchronized void releaseKingAccess() {
    king = false;
    notifyAll();
  }

  public synchronized int getDiamondCount() {
    return diamondCount;
  }

  public synchronized int getJewelCount() {
    return jewelCount;
  }

  public synchronized int getRubyCount() {
    return rubyCount;
  }

  public synchronized int getWoodenCoin() {
    return woodenCoin;
  }

  public synchronized int getGoldNugget() {
    return goldNugget;
  }

  public synchronized int getTreasureWorth() {
    return treasureWorth;
  }

  public synchronized int getTotalValuablesCount() {
    return getDiamondCount() + getJewelCount() + getRubyCount() + getWoodenCoin() + getGoldNugget();
  }
}
