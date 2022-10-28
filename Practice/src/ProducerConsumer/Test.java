package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test
{
  public static void main(String[] args)
  {
    // Create an ArrayBlockingQueue object with capacity
    // 4
    BlockingQueue<Integer> bqueue
        = new ArrayBlockingQueue<Integer>(4);

    // Create 1 object each for producer
    // and consumer and pass them the common
    // buffer created above
    Producer p1 = new Producer(bqueue);
    Consumer c1 = new Consumer(bqueue);

    Thread pThread = new Thread(p1);
    Thread cThread = new Thread(c1);

    pThread.start();
    cThread.start();
  }
}
