package Log_Multiton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogMultiton
{
  private static Map<String, LogMultiton> map = new HashMap<>();
  private ArrayList<LogLine> logLines = new ArrayList<>();
  private String filename;

  private LogMultiton(String filename)
  {
    this.filename = filename;
  }

public static LogMultiton getInstance(String filename)
{
  LogMultiton instance = map.get(filename);
  if(instance == null)
  {
    synchronized (map)
    {
      instance = map.get(filename);
      if(instance == null)
      {
        instance = new LogMultiton(filename);
        map.put(filename, instance);
      }
    }
  }
  return instance;
}

  public void addLog(String text)
  {
    LogLine log = new LogLine(text);
    logLines.add(log);
    addToFiles(log);
  }

  private void addToFiles(LogLine log)
  {
    {
      if (log == null)
      {
        return;
      }
      BufferedWriter out = null;
      try
      {
        out = new BufferedWriter(new FileWriter(filename, true));
        out.write(log + "\n");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      finally
      {
        try
        {
          out.close();
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }
  }

  @Override public String toString()
  {
    return "filename='" + filename + '\'' ;
  }
}
