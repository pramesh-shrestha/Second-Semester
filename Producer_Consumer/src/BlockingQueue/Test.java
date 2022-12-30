package BlockingQueue;

import BlockingQueue.BlockingQueue;

public class Test
{
  public static void main(String[] args)
  {
    Buffer<String> text = new BlockingQueue<String>(3);

    while (true) {
      for (int i = 0; i <= 3; i++) {
        new Thread(() -> {
          text.put("a");
        }).start();
      }

      for (int i = 0; i <= 3; i++) {
        new Thread(() -> {
          text.take();
        }).start();
      }
    }
  }
}
