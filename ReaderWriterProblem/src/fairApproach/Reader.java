package fairApproach;

public class Reader implements Runnable{
  private BalancedReaderWriter sharedResource;
  private String name;

  public Reader(BalancedReaderWriter sharedResource, String name) {
    this.sharedResource = sharedResource;
    this.name = name;
  }

  @Override
  public void run() {
    while(true){
      System.out.println(name + " wants read access.");
      sharedResource.acquireRead();
      int i = sharedResource.doRead();
      System.out.println(name + " read " + i);
      sharedResource.releaseRead();;
      System.out.println(name + " released read access ");
    }
  }
}
