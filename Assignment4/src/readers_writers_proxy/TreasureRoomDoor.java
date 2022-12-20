package readers_writers_proxy;

import multiton.MultitonValuables;

import java.util.ArrayList;

public interface TreasureRoomDoor extends TreasureRoomDoorAccess {
  public void add(ArrayList<MultitonValuables> valuables);
  public MultitonValuables retrieve(int choice);
  public int look();

  int getTotalValuablesCount();
}
