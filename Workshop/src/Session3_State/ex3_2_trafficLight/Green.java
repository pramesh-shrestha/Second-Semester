package Session3_State.ex3_2_trafficLight;

public class Green implements LightState{
  @Override
  public void next(Lights light) {
    light.turnOff(Lights.GREEN);
    light.turnOn(Lights.YELLOW);
    light.setLightState(new Yellow());
  }
}
