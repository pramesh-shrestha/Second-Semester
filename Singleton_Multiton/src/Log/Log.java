package Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log
{
  private static Log instance;
  private static final Lock lock = new ReentrantLock();
  private ArrayList<LogLine> logLines;

  private Log()
  {
    logLines = new ArrayList<>();
  }

  public static Log getInstance()
  {
    if(instance == null)
    {
      synchronized (lock)
      {
        if(instance == null)
          instance = new Log();
      }
    }
    return instance;
  }

  //addLog
  public void addLog(String text)
  {
    LogLine log = new LogLine(text);
    logLines.add(log);
    addToFiles(log);

  }

  public ArrayList<LogLine> getAll()
  {
    return logLines;
  }

  @Override public String toString()
  {
    return logLines + "";
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
        String filename = "Log-" + log.getDateTime().getSortableDate() + ".txt";
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
}
