package Session3_State.ex3_2_trafficLight;

public class Red implements LightState {

  @Override
  public void next(Lights light) {
    light.turnOn(Lights.RED);
    light.turnOn(Lights.YELLOW);
    light.setLightState(new YellowRed());

  }
}
