package Session3_State.ex3_2_trafficLight;

public class Yellow implements LightState{
  @Override
  public void next(Lights light) {
    light.turnOff(Lights.GREEN);
    light.turnOn(Lights.RED);
    light.setLightState(new Red());
  }
}
