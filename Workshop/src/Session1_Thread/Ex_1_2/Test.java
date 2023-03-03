package Session1_Thread.Ex_1_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Test {
  public static long[] generateRandomNumbers(int num){
    long[] arr = new long[num];
    Random random = new Random();
    for (int i = 0; i < num; i++) {
      arr[i] = random.nextInt();
    }
    return arr;
  }
  public static void main(String[] args) {

    Runnable sortRunnable = new Runnable() {
      @Override
      public void run() {
        long[] array = generateRandomNumbers(2000000);
        Arrays.sort(array);
      }
    };

    Runnable parallelRunnable = () ->{
      long[] array = generateRandomNumbers(2000000);
      Arrays.parallelSort(array);
    };

    System.out.println(Run.ruAndTime(sortRunnable) + " milliseconds");
    System.out.println(Run.ruAndTime(parallelRunnable) + " milliseconds");

  }
}
