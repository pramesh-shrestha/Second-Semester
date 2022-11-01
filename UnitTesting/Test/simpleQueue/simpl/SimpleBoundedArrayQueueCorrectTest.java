package simpleQueue.simpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBoundedArrayQueueCorrectTest
{
  private queue.QueueADT<String> q;

  @Before
  public void setUp() throws Exception
  {
    q = new SimpleBoundedArrayQueueCorrect<>(6);
  }

  @Test
  public void testEnqueueWithOneElement()
  {
    q.enqueue("Elephant");
    assertEquals("Elephant",q.first());
    assertFalse(q.isEmpty());
  }

  @Test
  public void testEnqueueWithSixElements()
  {
    for (int i = 0; i < 6; i++)
    {
    q.enqueue("Elephant" + i);
    }
    assertEquals("Elephant0",q.first());
    assertFalse(q.isEmpty());
    assertEquals(6, q.size());
    assertTrue(q.contains("Elephant5"));
    assertEquals(1,q.indexOf("Elephant1"));
  }
}