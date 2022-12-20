package Strategy.Compressor;

import Strategy.Compressor.ConcreteStrategy.SevenCCompression;
import Strategy.Compressor.ConcreteStrategy.ZipCompression;
import Strategy.Compressor.Context.Compressor;

import java.util.ArrayList;
import java.util.Arrays;

public class Test
{
  public static void main(String[] args)
  {
    Compressor compressor = new Compressor(new ZipCompression());

    ArrayList<String> via = new ArrayList<>(Arrays.asList("designPattern.txt","database.txt"));
    compressor.compress(via);

    System.out.println("-----------------------------------------");

    compressor.setMethod(new SevenCCompression());
    compressor.compress(via);

  }
}
