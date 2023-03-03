package Session1_Thread.Ex_1_8;

public class Start {
  public static void main(String[] args) {
    Tortoise tortoise = new Tortoise();
    new Thread(tortoise).start();
    new Thread(new Hare(tortoise)).start();
  }
}
