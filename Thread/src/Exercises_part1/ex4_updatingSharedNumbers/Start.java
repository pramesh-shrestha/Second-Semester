package Exercises_part1.ex4_updatingSharedNumbers;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    Counter counter = new Counter();
    Thread th1 = new Thread(new CountIncrementer(counter));
    th1.start();
//    th1.join(); //This means that the main thread should stop executing further until th1 execution is completed. And,then start th2

    Thread th2 = new Thread(new CountIncrementer(counter));
    th2.start();
  }
}
