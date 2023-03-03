package Session1_Thread.Ex_1_2;

//1.2	Runnable interface
//a.	Create a static method that takes a Runnable, runs it and returns the number of milliseconds it took to run it. The method should have this signature:
//public static long runAndTime(Runnable runnable)
//    Use the runAndTime() to test the running time of sort() and parallelSort().
//    b.	Change the method to return the running time in nanoseconds instead (Hint: Use BigInteger).


public class Run {
  public static long ruAndTime(Runnable runnable){
    long start = System.currentTimeMillis();
    runnable.run();
    long end = System.currentTimeMillis();
    return end - start;
  }
}
