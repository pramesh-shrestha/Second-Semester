package Session3_State.ex3_2_trafficLight;

public class YellowRed implements LightState{
  @Override
  public void next(Lights light) {
    light.turnOff(Lights.RED,Lights.YELLOW);
    light.turnOn(Lights.GREEN);
    light.setLightState(new Green());
  }
}
