package ex5_SingleLaneBridge;

public class Bridge implements Lane{
  private int waitingCarsOnRight = 0;
  private int waitingCarsOnLeft = 0;
  private int rightCarsOnSingleLane = 0;
  private int leftCarsOnSingleLane = 0;

  @Override
  public synchronized void enterFromTheLeft() {
    waitingCarsOnLeft++;
    while(rightCarsOnSingleLane > 0 || waitingCarsOnRight > waitingCarsOnLeft)
    {
      try {
        if(rightCarsOnSingleLane > 0)
          System.out.println("Left request denied. Cars from right are crossing the bridge");
        else if(waitingCarsOnRight > waitingCarsOnLeft)
          System.out.println("Left request denied. More cars waiting on the right side.");
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingCarsOnLeft--;
    leftCarsOnSingleLane++;
  }

  @Override
  public synchronized void exitToTheRight() {
    leftCarsOnSingleLane--;
    if(leftCarsOnSingleLane == 0)
      notifyAll();
  }

  @Override
  public synchronized void enterFromTheRight() {
    waitingCarsOnRight++;
    while(leftCarsOnSingleLane > 0 || waitingCarsOnLeft > waitingCarsOnRight) {
      try {
        if(leftCarsOnSingleLane > 0)
          System.out.println("Right request denied. Cars from left are crossing the bridge");
        else if( waitingCarsOnLeft > waitingCarsOnRight)
          System.out.println("Right request denied. More cars waiting on the left side.");
        wait();
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    waitingCarsOnRight--;
    rightCarsOnSingleLane++;

  }

  @Override
  public synchronized void exitToTheLeft() {
    rightCarsOnSingleLane--;
    if(rightCarsOnSingleLane == 0)
      notifyAll();
  }

  public synchronized void crossBridge(String name)
  {
    System.out.println(name + " crossing Bridge");
  }
}
