package lesson6_1.model;
import java.util.ArrayList;
public class Converter

  {
    private ArrayList<String> logList;

    public Converter()
    {
      this.logList = new ArrayList<>();
    }

    public String toUpperCase(String txt)
    {
      return txt.toUpperCase();
    }

    public void addLog(String txt)
    {
      logList.add(txt);
    }

    public int getLogSize()
    {
      return logList.size();
    }

    public ArrayList<String> getLogList()
    {
      return logList;
    }
  }


