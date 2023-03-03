package Session2_Thread.Ex2_2_synchronized_list;

public class Start {
  public static void main(String[] args) {
    ListContainer container = new ListContainer();
    new Thread(new InsertNumber(container)).start();
    new Thread(new InsertNumber(container)).start();
  }
}
