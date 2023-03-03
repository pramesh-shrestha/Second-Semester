package Session4_Observer.trafficLight;

public interface TrafficLightState {
    LightColor getColor();
    void next(TrafficLight trafficLight);
}