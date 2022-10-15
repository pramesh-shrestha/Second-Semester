package ex2_TrafficLight_PropertyChangeSupport;

import ex2_TrafficLight_PropertyChangeSupport.Observer_Listener.Car;
import ex2_TrafficLight_PropertyChangeSupport.Observer_Listener.Taxi;
import ex2_TrafficLight_PropertyChangeSupport.Observer_Listener.Truck;
import ex2_TrafficLight_PropertyChangeSupport.Observer_Listener.Van;
import ex2_TrafficLight_PropertyChangeSupport.Subject.TrafficLight;


public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    TrafficLight trafficLight = new TrafficLight();
    Car car1 = new Car(1);
    Taxi taxi = new Taxi(trafficLight);
    Truck truck = new Truck(trafficLight);
    Van van = new Van(trafficLight);
    trafficLight.addPropertyChangeListener(car1);
    trafficLight.start();
  }
}
