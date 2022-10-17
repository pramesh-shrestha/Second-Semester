package LambdaExpression.LamdaExample;

import LambdaExpression.LamdaExample.Addition;

public class Sum
{
  public static void main(String[] args)
  {
    Addition myAddition = (a,b) -> a + b;
    System.out.println(myAddition.sum(2,3));
  }

}
