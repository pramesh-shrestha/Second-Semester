package readers_writers_proxy;

public interface TreasureRoomDoorAccess {
  public void acquireRead();
  public void releaseRead();
  public void acquireTransporterAccess();
  public void releaseTransporterAccess();
  void acquireKingAccess();
  void releaseKingAccess();
}
