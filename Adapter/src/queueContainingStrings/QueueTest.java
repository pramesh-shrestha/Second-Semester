package queueContainingStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
  private Queue queue;


  @org.junit.Before
  public void setUp() throws Exception {
    queue = new Queue(2);
  }


  @Test(expected = IllegalStateException.class)
  public void enqueueTest() {
    queue.enqueue("as");
    queue.enqueue("ab");
    queue.enqueue("ab");
  }

  @Test(expected = IllegalArgumentException.class)
  public void enqueueNullTest() {
   queue.enqueue(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void dequeue() {
    queue.dequeue();
  }

  @Test(expected = IllegalStateException.class)
  public void testFirst() {
    queue.first();
  }

  @Test
  public void testSize() {
    queue.enqueue("sdfads");
    assertEquals(1,queue.size());
  }

  @Test
  public void isEmpty() {
    assertTrue(queue.isEmpty());
  }
  @Test
  public void isNotEmpty() {
    queue.enqueue("12");
    assertFalse(queue.isEmpty());
  }

  @Test
  public void shouldReturnFirstIndex() {
    queue.enqueue("12");
    queue.enqueue("12");
    assertEquals(0, queue.indexOf("12"));
  }

  @Test
  public void testContainsWrongElement() {
    queue.enqueue("12");
    assertFalse(queue.contains("1"));
  }

  @Test
  public void testContainsCorrectElement() {
    queue.enqueue("12");
    assertTrue(queue.contains("12"));
  }
}