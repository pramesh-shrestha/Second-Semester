package BlockingQueue;

import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T>
{
  private QueueADT<T> queue;

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
        System.out.println("Insertion on waiting state");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new IllegalArgumentException(e);
      }
    }
    queue.enqueue(element);
    System.out.println("Inserted");
    notifyAll();
  }

  @Override
  public synchronized T take()
  {
    while(queue.isEmpty())
    {
      try
      {
        System.out.println("Removal on waiting state");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    T dequeue = queue.dequeue();
    System.out.println("Removing element");
    notifyAll();
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
