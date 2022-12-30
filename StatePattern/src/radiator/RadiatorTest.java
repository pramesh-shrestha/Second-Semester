package radiator;

public class RadiatorTest
{
  private static void sleep(){
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  public static void main(String[] args) {

    //creating OffState object assuming it to be a default state to pass to the Radiator constructor as an argument
    OffState offState = new OffState();
    Radiator radiator = new Radiator(offState);
    System.out.println("Power State: " + radiator.getPower());
    sleep();
    radiator.turnUp();
    System.out.println("Power State: " + radiator.getPower());
    sleep();
    radiator.turnUp();
    System.out.println("Power State: " + radiator.getPower());
    sleep();
    radiator.turnUp();
    System.out.println("Power State: " + radiator.getPower());
//    radiator.turnDown();
//    System.out.println("Power State: " + radiator.getPower());
    try {
      Thread.sleep(10000);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Power State: " + radiator.getPower());
  }


}
