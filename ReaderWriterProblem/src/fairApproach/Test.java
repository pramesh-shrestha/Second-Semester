package fairApproach;

public class Test {
  public static void main(String[] args) {
    BalancedReaderWriter brw = new BalancedReaderWriter();

    for (int i = 0; i < 10; i++) {
      Reader reader = new Reader(brw, "Reader" + i);
      new Thread(reader).start();
    }

    for (int i = 0; i < 4; i++) {
      Writer writer = new Writer(brw, "Writer" + i);
      new Thread(writer).start();
    }
  }
}
