package Session2_Thread.Ex2_2_synchronized_list;

public class InsertNumber implements Runnable{
  private ListContainer container;

  public InsertNumber(ListContainer container) {
    this.container = container;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100000; i++) {
      container.add(i);
    }
    System.out.println(container.getLength());
  }
}
