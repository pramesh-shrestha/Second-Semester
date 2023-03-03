package Session3_State.ex3_2_trafficLight;

public class Test {
  public static void main(String[] args) {
    Lights lights = new Lights(new Red());
    lights.next();
    lights.printLights();
    lights.next();
    lights.printLights();

  }
}
