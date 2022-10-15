package phone;

public class SilentState implements PhoneState
{
  @Override public void onReceiveMessage(String txt, Phone phone)
  {
    System.out.println("Message received");
    System.out.println(txt);

  }

  @Override public void onReceiveCall(Phone phone)
  {
    phone.lightUpScreen();

  }

  @Override public void onVolumeButtonUp(Phone phone)
  {
    phone.setState(new SoundState());
    phone.turnVolumeUp();
  }

  @Override public void onVolumeButtonDown(Phone phone)
  {
    phone.setState(new SoundState());
    phone.turnVolumeDown();
  }
}
