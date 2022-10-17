package LambdaExpression.Runnable_using_Lambdas;

public class RunnableExample
{
    Thread thread = new Thread(() -> {
      for (int i = 1; i < 5; i++)
      {
        System.out.println(i);
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }
    });
}
