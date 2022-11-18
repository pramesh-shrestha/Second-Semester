package BlockingQueue;

import BlockingQueue.BlockingQueue;

public class Test
{
  public static void main(String[] args)
  {
    Buffer<String> text = new BlockingQueue<String>(4);

    while(true)
    {
      while(!text.isFull())
      {
        text.put("a");
        System.out.println("Inserted");
      }
      System.out.println("Insertion on waiting state");
      while(!text.isEmpty())
      {
        text.take();
        System.out.println("Removing element");
      }
      System.out.println("Removal on waiting state");

    }
  }
}
