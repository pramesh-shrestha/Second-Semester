package Session1_Thread.Ex_1_7;

import Session1_Thread.Ex_1_4.Numbers;

public class Start {
  public static void main(String[] args) {
    int count = 10;

    new Thread(() ->{
      for (int i = 0; i < count; i++) {
        System.out.println(i);
        try {
          Thread.sleep(1000);
        }
        catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }).start();

//    Runnable number = ()->{
//      for (int i = 0; i < count; i++) {
//        System.out.println(i);
//        try {
//          Thread.sleep(1000);
//        }
//        catch (InterruptedException e) {
//          throw new RuntimeException(e);
//        }
//      }
//    };
//    new Thread(number).start();
  }

}
