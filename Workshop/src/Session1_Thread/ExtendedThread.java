package Session1_Thread;

public class ExtendedThread extends Thread{

  public void run(){
    System.out.println("Hello from a thread!");
  }

  public static void main(String[] args) {
    (new ExtendedThread()).start();
  }
}
