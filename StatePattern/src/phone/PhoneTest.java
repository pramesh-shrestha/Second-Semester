package phone;

public class PhoneTest
{
  public static void main(String[] args)
  {
    Phone phone = new Phone();
    System.out.println(phone.getVolume());
    //increasing volume 1
    phone.volumeUpButton();
    System.out.println("Increased volume to 1");
    System.out.println(phone.getVolume());
    phone.receiveCall();
    //decreasing volume to 0
    phone.volumeDownButton();
    System.out.println("Decreased volume to 0");
    System.out.println(phone.getVolume());
    phone.receiveCall();
    //Changing to vibrate mode
    phone.setState(new VibrateState());
    System.out.println("Changed to vibrate mode");
    phone.receiveCall();








  }
}
