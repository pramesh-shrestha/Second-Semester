package Compressor.ConcreteStrategy;

import Compressor.Strategy.CompressionMethod;

public class ZipCompression implements CompressionMethod
{
  @Override public String compress(String filename)
  {
    System.out.println("It is compressing the file");
    return filename + "-zip";
  }
}
