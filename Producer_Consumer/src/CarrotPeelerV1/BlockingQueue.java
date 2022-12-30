package CarrotPeelerV1;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T>
{
  private QueueADT<T> queue;
  private int count = 1;

  public BlockingQueue(int capacity)
  {
    queue = new BoundedArrayQueue<>(capacity);
  }

  @Override
  public synchronized void put(T element)
  {
    while(queue.isFull())
    {
      try
      {
        System.out.println("Buffer is full. Carrot peeler is waiting");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new IllegalArgumentException(e);
      }
    }
    queue.enqueue(element);
    System.out.println("Carrot " + count + " is peeled");
    count++;
    if(queue.isFull())
    {
      count = 1;
      notifyAll();
    }
  }

  @Override
  public synchronized T take()
  {
    while(queue.isEmpty())
    {
      try
      {
        System.out.println("Buffer is empty. Carrot eaters are waiting.");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    T dequeue = queue.dequeue();
    System.out.println("Carrot "+ count + " is eaten");
    count++;
    if(queue.isEmpty())
    {
      count = 1;
      notifyAll();
    }
    return dequeue;
  }

  @Override
  public synchronized T look()
  {
    if(!queue.isEmpty())
     return queue.first();
    else
      return null;
  }

  @Override
  public synchronized boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override
  public synchronized boolean isFull()
  {
    return queue.isFull();
  }

  @Override
  public synchronized int size()
  {
    return queue.size();
  }
}
