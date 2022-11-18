package ex5_SingleLaneBridge;

public class LeftCars implements Runnable{
  private Bridge bridge;
  private String name;

  public LeftCars(String name, Bridge bridge) {
    this.bridge = bridge;
    this.name = name;
  }

  @Override
  public void run() {
    while(true){
      bridge.enterFromTheLeft();
      bridge.crossBridge(name);
      bridge.exitToTheRight();
      System.out.println("Left cars exiting the bridge");
    }
  }
}
