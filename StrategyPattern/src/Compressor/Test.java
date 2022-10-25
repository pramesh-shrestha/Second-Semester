package Compressor;

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
    CompressionMethod method = new ZipCompression();
    Compressor compressor = new Compressor(method);

    ArrayList<String> via = new ArrayList<>(Arrays.asList("Pramesh.txt","Rajib.blacktxt", "suhani.V"));
    compressor.compress(via);

  }
}
