package Session1_Thread.Ex_1_5;

public class Start {
  public static void main(String[] args) throws InterruptedException {

    Thread numbersThread1 = new Thread(new Numbers(0,10));
    Thread numbersThread2 = new Thread(new Numbers(11,20));
    Thread numbersThread3 = new Thread(new Numbers(21,30));

    numbersThread1.start();
    numbersThread1.join();
    numbersThread2.start();
    numbersThread2.join();
    numbersThread3.start();
    numbersThread3.join();

    System.out.println("Finished");
  }
}