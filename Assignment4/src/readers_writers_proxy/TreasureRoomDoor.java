package readers_writers_proxy;

import multiton.MultitonValuables;

import java.util.ArrayList;

public interface TreasureRoomDoor extends TreasureRoomDoorAccess {
  public void add(ArrayList<MultitonValuables> valuables, String userType);
  public MultitonValuables retrieve(int choice, String userType);
  public int look(String userType);

  int getTotalValuablesCount();
}
