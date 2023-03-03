package Compressor.Context;

import Compressor.Strategy.CompressionMethod;

import java.util.List;

public class Compressor
{
  private CompressionMethod method;
  public Compressor(CompressionMethod method)
  {
    this.method = method;
  }
  public void setMethod(CompressionMethod method) {
    this.method = method;
  }
  public void compress(List<String> files)
  {
    System.out.println("It is compressing the file");
    for (int i = 0; i < files.size(); i++)
    {
      String compress = method.compress(files.get(i));
      System.out.println(compress);

    }
  }
}
