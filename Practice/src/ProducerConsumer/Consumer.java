package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
public class Consumer implements Runnable
{
  private BlockingQueue<Integer> queue;
  int taken = 0;
  public Consumer(BlockingQueue<Integer> queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {
    while (taken != 4) {
      try {
        taken = queue.take();
        System.out.println("Consumed " + taken);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

