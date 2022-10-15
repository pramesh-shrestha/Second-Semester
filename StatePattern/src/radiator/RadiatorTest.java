package radiator;

public class RadiatorTest
{
  public static void main(String[] args)
  {

    //creating OffState object assuming it to be a default state to pass to the Radiator constructor as an argument
    OffState offState = new OffState();
    Radiator radiator = new Radiator(offState);
    System.out.println("Power of OffState: " + radiator.getPower());
    System.out.println();

    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();
    System.out.println(radiator.getPower());
    radiator.turnUp();

  

  }
}
