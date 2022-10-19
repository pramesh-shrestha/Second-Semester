package DependencyInversionExample;

public class User
{
  private Database database;

  public User(Database database)
  {
    this.database = database;
  }

  public void add(String data)
  {
    database.persist(data);
  }
}
