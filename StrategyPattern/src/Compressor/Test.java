package Compressor;

import Compressor.ConcreteStrategy.SevenCCompression;
import Compressor.ConcreteStrategy.ZipCompression;
import Compressor.Context.Compressor;
import Compressor.Strategy.CompressionMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
  public static void main(String[] args)
  {
    Compressor compressor = new Compressor(new ZipCompression());

    ArrayList<String> via = new ArrayList<>(Arrays.asList
        ("designPattern.txt","database.txt"));
    compressor.compress(via);

    System.out.println("-----------------------------------------");

    compressor.setMethod(new SevenCCompression());
    compressor.compress(via);

  }
}
