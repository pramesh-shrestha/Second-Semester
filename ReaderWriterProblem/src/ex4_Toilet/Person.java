package ex4_Toilet;

public class Person implements Runnable{
  private ToiletBuilding toilet;

  public Person(ToiletBuilding toilet) {
    this.toilet = toilet;
  }

  @Override
  public void run() {
    while(true){
      toilet.stepIntoCabin();
      toilet.useToilet();
      System.out.println(toilet.getSize() - toilet.getActiveToiletUser() + " toilets are in use");
      toilet.leaveCabin();
      try {
        Thread.sleep(100);
      }
      catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
