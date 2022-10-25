package Compressor.ConcreteStrategy;

import Compressor.Strategy.CompressionMethod;

import java.lang.management.CompilationMXBean;

public class SevenCCompression implements CompressionMethod
{
  @Override public String compress(String filename)
  {
    System.out.println("It is compressing the file.");
    return filename + "-zip";
  }
}
