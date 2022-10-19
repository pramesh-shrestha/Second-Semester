package uppercaseWithLogs.model;

public class LogEntry
{
  private String input;
  private String output;

  public LogEntry(String input, String output)
  {
    this.input = input;
    this.output = output;
  }

  public String getOutput()
  {
    return output;
  }

  public String getInput()
  {
    return input;
  }
}
