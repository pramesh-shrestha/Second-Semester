package DependencyInversionExample;

public class OracleDatabase implements Database
{
  public void persist(String data)
  {
    System.out.println("Oracle has persisted: " + data);
  }
}
