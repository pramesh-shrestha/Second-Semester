package Session3_State.ex3_1_simplePhone;

public class Vibrate implements SpeakerState {
  @Override
  public void click(Phone phone) {
    phone.setState(new Silent());
  }

  @Override
  public void alert(Phone phone) {
    System.out.println("BZZZZ");
  }
}
