package Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieJar
{
  private List<Cookie> list;
  private int maxSize;

  public CookieJar(int size)
  {
    maxSize = size;
    list = new ArrayList<>(size);
  }

  public synchronized int getMaxSize()
  {
    return maxSize;
  }

  public synchronized List<Cookie> getList()
  {
    return list;
  }

  public synchronized void startBaking(List<Cookie> cookies)
  {
    System.out.println("Starts baking..");
    try
    {
      Thread.sleep(5000);
      finishedBaking(cookies);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    while(list.size() >= maxSize)
    {
      try
      {
        System.out.println("Jar is full. Baker is waiting");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }


  }

  private void finishedBaking(List<Cookie> cookies)
  {
    for (int i = 0; i < cookies.size(); i++)
    {
      if(list.size() < maxSize) {
        System.out.println("cookies added to the jar");
        list.add(cookies.get(i));
      }
    }
    if(list.size() >= maxSize)
      notifyAll();

  }

  public synchronized void eat()
  {
    while(list.size() == 0)
    {
      try
      {
        System.out.println("Jar is empty. Eater is waiting.");
        wait();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    list.remove(0);
    System.out.println("Cookies removed from the jar");
    if(list.size() < 5)
    {
      System.out.println("Cookies less than 5 in the jar");
      notifyAll();

    }


  }

}
