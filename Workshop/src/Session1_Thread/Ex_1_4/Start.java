package Session1_Thread.Ex_1_4;

public class Start {
  public static void main(String[] args) throws InterruptedException {

    Thread numbersThread = new Thread(new Numbers(57));
    Thread charactersThread = new Thread(new Characters(33));

    numbersThread.start();
    charactersThread.start();
    numbersThread.join();
    charactersThread.join();
    System.out.println("Finished");
  }
}