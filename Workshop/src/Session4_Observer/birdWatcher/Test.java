package Session4_Observer.birdWatcher;

public class Test
{
  public static void main(String[] args)
  {
      Bird bird = new Bird();

      new BirdWatcher(bird);
      new BlindBirdWatcher(bird);

      bird.BirdBehavior();


  }
}
