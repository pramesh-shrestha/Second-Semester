package Session1_Thread.Ex_1_2;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {
  public static void main(String[] args) {
    int[] arr = generateRandomArray(1000000);

//    long sortTime = runAndTime(() -> Arrays.sort(arr));
//    long parallelSortTime = runAndTime(() -> Arrays.parallelSort(arr));

    Runnable sort = () ->{
      Arrays.sort(arr);
    };

    Runnable parallel = () ->{
      Arrays.parallelSort(arr);
    };

    long sortTime = runAndTime(sort);
    long parallelSortTime = runAndTime(parallel);

    System.out.println("Sort time: " + sortTime + " ns");
    System.out.println("Parallel sort time: " + parallelSortTime + " ns");
  }

  public static int[] generateRandomArray(int size) {
    int[] arr = new int[size];
    Random random = new Random();
    for (int i = 0; i < size; i++) {
      arr[i] = random.nextInt();
    }
    return arr;
  }
//System.currentTimeMillis() returns the current time in milliseconds. This time is stored in the startTime variable.
//  The runnable argument is executed by calling the run() method on it.
//      System.currentTimeMillis() is called again to get the current time in milliseconds. This time is stored in the endTime variable.
//  The difference between endTime and startTime gives the duration of time it took to run the runnable in milliseconds.
//
  public static long runAndTime(Runnable runnable) {
    long startTime = System.nanoTime();
    runnable.run();
    long endTime = System.nanoTime();
    return endTime - startTime;
  }
}





