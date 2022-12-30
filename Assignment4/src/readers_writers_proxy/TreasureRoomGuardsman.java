package readers_writers_proxy;

import multiton.MultitonValuables;
import singleton.SingletonLog;

import java.util.ArrayList;

public class TreasureRoomGuardsman implements TreasureRoomDoor{
  //this proxy class should delegate the Real Subject i.e. Treasure Room
  private TreasureRoom treasureRoom;
  public TreasureRoomGuardsman(TreasureRoom treasureRoom) {
    this.treasureRoom = treasureRoom;
  }

  @Override
  public void add(ArrayList<MultitonValuables> valuables) {
    treasureRoom.add(valuables);
  }
  @Override
  public MultitonValuables retrieve(int choice) {
    return treasureRoom.retrieve(choice);
  }
  @Override
  public int look() {
    return treasureRoom.look();
  }
  @Override
  public int getTotalValuablesCount() {
    return treasureRoom.getTotalValuablesCount();
  }

  @Override
  public void acquireRead() {
    treasureRoom.acquireRead();
  }

  @Override
  public void releaseRead() {
    treasureRoom.releaseRead();
  }

  @Override
  public void acquireTransporterAccess() {
    treasureRoom.acquireTransporterAccess();
  }

  @Override
  public void releaseTransporterAccess() {
    treasureRoom.releaseTransporterAccess();
  }

  @Override
  public void acquireKingAccess() {
    treasureRoom.acquireKingAccess();
  }

  @Override
  public void releaseKingAccess() {
    treasureRoom.releaseKingAccess();
  }
}
