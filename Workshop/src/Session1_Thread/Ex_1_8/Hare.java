package Session1_Thread.Ex_1_8;

import javax.sound.midi.Soundbank;
import java.util.Random;

public class Hare implements Runnable{
  private Tortoise tortoise;
  private int count = 0;

  public Hare(Tortoise tortoise) {
    this.tortoise = tortoise;
  }

  public void increment(){
    count++;
  }

  @Override
  public void run() {
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      increment();
      while(count - tortoise.getCount() > 50){
        System.out.println("Hare is ahead by more than 50 meters. Therefore, it sleeps.");
        int rand = random.nextInt(1000);
        try {
          Thread.sleep(rand);
        }
        catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Hare wakes up after " +  rand + " milliseconds and checks again for distance difference.");
      }
    }
    System.out.println("Hare reached the finish line");
  }
}
