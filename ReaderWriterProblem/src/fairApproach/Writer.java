package fairApproach;

public class Writer implements Runnable{
  private BalancedReaderWriter sharedResource;
  private String name;

  public Writer(BalancedReaderWriter sharedResource, String name) {
    this.sharedResource = sharedResource;
    this.name = name;
  }

  @Override
  public void run() {
    while(true){
      System.out.println(name + " wants write access " );
      sharedResource.acquireWrite();
      sharedResource.doWrite();
      System.out.println(name + " changed the variable to " + sharedResource.doRead());
      sharedResource.releaseWrite();
      System.out.println(name + " released write access");
    }
  }
}
