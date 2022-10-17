import java.util.ArrayList;
import java.util.Random;
  public class lotto1
  {
    public static void main(String[] args)
    {
      ArrayList<Integer> numbers = new ArrayList<>();

      Random random = new Random();

      while(numbers.size() != 2)
      {
        int num = random.nextInt(12) + 1;
        if(!numbers.contains(num))
          numbers.add(num);
      }
      System.out.println(numbers);
    }
  }

