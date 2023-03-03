package Session4_Observer.trafficLight;

public class Red implements TrafficLightState {
    @Override
    public LightColor getColor() {
        return LightColor.RED;
    }

    @Override
    public void next(TrafficLight trafficLight) {
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new YellowRed());
    }
}