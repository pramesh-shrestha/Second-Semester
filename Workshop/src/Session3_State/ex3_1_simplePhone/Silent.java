package Session3_State.ex3_1_simplePhone;

public class Silent implements SpeakerState {
  @Override
  public void click(Phone phone) {
    phone.setState(new Sound());
  }

  @Override
  public void alert(Phone phone) {

  }
}
