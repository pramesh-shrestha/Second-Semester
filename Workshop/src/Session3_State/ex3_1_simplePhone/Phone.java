package Session3_State.ex3_1_simplePhone;

public class Phone {
  private SpeakerState currentState;

  public Phone(SpeakerState speakerState) {
    currentState = speakerState;
  }

  public void onClick(){
    currentState.click(this);
  }

  public void onMessage(String message){
    currentState.alert(this);
  }

  public void setState(SpeakerState state){
    currentState = state;
  }

}
