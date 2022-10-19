package DependencyInversionExample;

public class MySqlDatabase implements Database
{
  public void persist(String data)
  {
    System.out.println("MySql has persisted: " + data);
  }
}
