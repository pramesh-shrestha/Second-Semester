package ex5_SingleLaneBridge;

public class RightCars implements Runnable{

  private Bridge bridge;
  private String name;


  public RightCars(String name,Bridge bridge) {
    this.bridge = bridge;
    this.name = name;
  }

  @Override
  public void run() {
    while(true){
      bridge.enterFromTheRight();
      bridge.crossBridge(name);
      bridge.exitToTheLeft();
      System.out.println("Right cars exiting the bridge");
    }
  }
}
