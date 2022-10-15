package ex5_BirdWatching;

import ex5_BirdWatching.observer.BirdWatcher;
import ex5_BirdWatching.observer.BlindBirdWatcher;
import ex5_BirdWatching.subject.Bird;

public class Test
{
  public static void main(String[] args)
  {
    try{
      Bird bird = new Bird();
      Thread thread = new Thread(bird);

      new BirdWatcher(bird);
      new BlindBirdWatcher(bird);
      thread.start();
    }
    catch (Exception e)
    {
      System.out.println("interrupted");
    }

  }
}
