package Multithreading;

public class TestMultiThreading
{
  public static void main(String[] args)
  {
    Multithreading multithreading = new Multithreading();
    Thread th = new Thread(multithreading);
    th.start();
  }
}
