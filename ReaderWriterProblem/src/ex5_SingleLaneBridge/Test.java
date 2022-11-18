package ex5_SingleLaneBridge;

public class Test {
  public static void main(String[] args) {
    Bridge bridge = new Bridge();

    for (int i = 0 ; i < 10; i++){
      new Thread(new LeftCars("Left car " + i, bridge)).start();
      new Thread(new RightCars("Right car" + i, bridge)).start();
      try {
        Thread.sleep(5000);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
