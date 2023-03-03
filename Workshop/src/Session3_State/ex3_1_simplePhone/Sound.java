package Session3_State.ex3_1_simplePhone;

import phone.VibrateState;

public class Sound implements SpeakerState {

  @Override
  public void click(Phone phone) {
    phone.setState(new Vibrate());
  }

  @Override
  public void alert(Phone phone) {
    System.out.println("DRRING");
  }
}
