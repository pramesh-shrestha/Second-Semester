package simpleQueue;

import org.junit.Before;
import org.junit.Test;
import simpleQueue.simpl.SimpleBoundedArrayQueueA;

import static org.junit.Assert.*;

public class QueueADTTest
{
  private QueueADT<String> q;

  //testing interface
  @Before
  public void setUp() throws Exception
  {
    q = new SimpleBoundedArrayQueueA<>(5);
  }

  //act
  @Test
  public void addOneToTheQueue()
  {
    q.enqueue("A");
    assertTrue(q.contains("A"));
    assertEquals(1,q.size());
    assertEquals(0,q.indexOf("A"));
  }

  @Test
  public void addMultipleElementToQueue()
  {
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");

    assertTrue(q.contains("D"));
    assertEquals(0,q.indexOf("B"));
    assertEquals(4, q.size());
  }

  //testing if the queue throws IllegalArgumentException if we try to deque from an empty queue
  @Test(expected = IllegalStateException.class)
  public void testingIllegalStateException()
  {
    q.dequeue();
  }

//testing if the queue throws IllegalArgumentException if we try to add null to the queue
  @Test(expected = IllegalArgumentException.class)
  public void nullArgumentResultsInIllegalStateException()
  {
    q.enqueue(null);
  }

  //checking if queue throws an IllegalStateException if we try to add elements more than the queue's capacity
  @Test(expected = IllegalStateException.class)
  public void fullQueueResultsInIllegalStateException()
  {
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    q.enqueue("A");
    q.enqueue("B");
  }
}