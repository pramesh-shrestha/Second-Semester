package Log_Multiton;

import javax.crypto.spec.PSource;

public class Test
{
  public static void main(String[] args)
  {
    LogMultiton logMultiton = LogMultiton.getInstance("file");
    logMultiton.addLog("SDJ");
    System.out.println(logMultiton);
  }


}
