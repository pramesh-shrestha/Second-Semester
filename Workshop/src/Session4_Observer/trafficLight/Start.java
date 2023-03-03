package Session4_Observer.trafficLight;


public class Start {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        TrafficlightRunner runner = new TrafficlightRunner(light);
        Thread lightThread = new Thread(runner);
        lightThread.start();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carD = new Car("D");
        Driver driverA = new Driver(carA);
        Driver driverB = new Driver(carB);
        Driver driverC = new Driver(carC);
        TaxiDriver driverD = new TaxiDriver(carD);
        carA.start();
        carB.start();
        carC.start();
        carD.start();
        Thread.sleep(1000);
        light.addPropertyChangeListener(driverA);
        light.addPropertyChangeListener(driverB);
        Thread.sleep(2000);
        light.addPropertyChangeListener(driverC);
        light.addPropertyChangeListener(driverD);
    }
}