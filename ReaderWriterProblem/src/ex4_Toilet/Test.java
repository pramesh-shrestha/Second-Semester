package ex4_Toilet;

public class Test {
  public static void main(String[] args) {
    ToiletBuilding toiletBuilding = new ToiletBuilding(5);
    for (int i = 0; i < 10 ; i++) {
      new Thread(new Person(toiletBuilding)).start();
    }
    Thread cleanerThread = new Thread(new CleaningPerson(toiletBuilding));
    cleanerThread.start();
  }
}
